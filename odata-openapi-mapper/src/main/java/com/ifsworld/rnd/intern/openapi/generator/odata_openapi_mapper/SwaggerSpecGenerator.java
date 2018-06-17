package com.ifsworld.rnd.intern.openapi.generator.odata_openapi_mapper;

import com.ifsworld.rnd.intern.openapi.generator.common.ServiceRoot;
import com.ifsworld.rnd.intern.openapi.generator.common.WriteJsonToFile;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.*;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Schema;
import com.ifsworld.rnd.intern.openapi.generator.swagger.SwaggerSpecInitializer;
import com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators.SwaggerObjectBuilder;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Info;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Swagger;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Tag;


import javax.json.JsonObject;
import java.util.HashMap;
import java.util.List;


public class SwaggerSpecGenerator {

    //hash map to store different object models for ease of mapping (entity type name - entity model mapping)
    private static HashMap<String, Object> models = new HashMap<String,Object>();

    //hash map to store Entity Types of different entity sets (entity set name - entity type name mapping)
    private static HashMap<String, String> entitySets = new HashMap<String, String>();


    //main method which maps OData services' metadata to swagger object and creates swagger.json object
    public static void generateSwaggerObject(Edmx edmx, String pathToSwaggerFile){

        SwaggerSpecInitializer.initializeSwaggerSpec();

        Swagger.getInstance().getInfo().setTitle("Open API specification for OData Service hosted at " + ServiceRoot.getInstance().getCurrentServiceRoot());

        SwaggerSpecGenerator swaggerSpecGenerator = new SwaggerSpecGenerator();

        //----Schema-----

        List<Schema> schemaList = edmx.getDataServices().getSchemas();

        if(schemaList != null && schemaList.size()>0){
            for (Schema schema: schemaList){

                //----Annotations------

                TAnnotations annotations = schema.getAnnotations();
                //update the Info object with annotations values
                if(annotations != null ) {
                    swaggerSpecGenerator.updateInfoObject(annotations.getAnnotation());
                }


                //----Annotation-----

                List<Annotation> annotationList = schema.getAnnotationList();
                //update the Info object with annotation values
                swaggerSpecGenerator.updateInfoObject(annotationList);


                //----EntityType-----

                List<TEntityType> entityTypeList = schema.getEntityTypeList();

                if(entityTypeList != null){

                    for(TEntityType entityType: entityTypeList) {
                        //update swagger "definitions" by adding new definition schema corresponding to the current EntityType
                        EntityModelsMapper.createDefinition(schema.getNamespace(), entityType);
                        //add current EntityType to models
                        models.put(schema.getNamespace() + "." + entityType.getName(), entityType);
                    }
                }


                //----ComplexType-----

                List<TComplexType> complexTypeList = schema.getComplexTypeList();

                if(complexTypeList != null ){

                    for(TComplexType complexType: complexTypeList) {
                        //update swagger "definitions" by adding new definition schema corresponding to the current ComplexType
                        EntityModelsMapper.createDefinition(schema.getNamespace(), complexType);
                        //add current ComplexType to models
                        models.put(schema.getNamespace() + "." + complexType.getName(), complexType);
                    }
                }


                //----EnumType-----

                List<TEnumType> enumTypeList = schema.getEnumTypeList();

                if(enumTypeList != null){

                    for(TEnumType enumType: enumTypeList) {
                        //update swagger "definitions" by adding new definition schema corresponding to the current EntityType
                        EntityModelsMapper.createDefinition(schema.getNamespace(), enumType);
                        //add current EntityType to models
                        models.put(schema.getNamespace() + "." + enumType.getName(), enumType);
                    }
                }

                //----Actions-----

                List<TAction> actionList = schema.getActionList();

                if(actionList != null){

                    for (TAction action : actionList){
                        //add current Action to models
                        models.put(schema.getNamespace() + "." + action.getName(), action);
                    }
                }


                //----Functions-----

                List<TFunction> functionList = schema.getFunctionList();

                if(functionList != null){

                    for(TFunction function : functionList){
                        //add current Function to models
                        models.put(schema.getNamespace() + "." + function.getName(), function);
                    }
                }



                //----EntityContainer-----

                TEntityContainer entityContainer = schema.getEntityContainer();

                if(entityContainer != null){

                    //----Annotation-----

                    List<Annotation> entityContainerAnnotationList = entityContainer.getAnnotationList();

                    if (entityContainerAnnotationList != null) {
                        //update the Info object
                        swaggerSpecGenerator.updateInfoObject(entityContainerAnnotationList);
                        //update "consumes" and "produces" arrays
                        swaggerSpecGenerator.updateConsumesAndProduces(entityContainerAnnotationList);
                    }

                    //----EntitySet-----

                    List<TEntitySet> entitySetList = entityContainer.getEntitySetList();

                    if (entitySetList != null && entitySetList.size()>0) {

                        for (TEntitySet entitySet : entitySetList) {

                            //update "paths" swagger object with pathItems relevant to current entity set
                            if (models.get(entitySet.getEntityType()) instanceof TEntityType) {
                                PathMapper.mapPathItems(entitySet, (TEntityType) models.get(entitySet.getEntityType()));
                            } else {
                                PathMapper.mapPathItems(entitySet, null);
                            }

                            //update entitySet hash map with current entity set's name and the EntityType related to it
                            entitySets.put(entitySet.getName(), entitySet.getEntityType());

                            //----Annotation-----

                            List<Annotation> entitySetAnnotationList = entitySet.getAnnotationList();

                            //update "tags" array of the "swagger" object
                            swaggerSpecGenerator.updateTags(entitySet.getName(), annotationList);


                            //----NavigationPropertyBinding-----
                        }

                    }


                    //----Singleton-----

                    List<TSingleton> singletonList = entityContainer.getSingletonList();

                    if(singletonList != null){

                        for(TSingleton singleton: singletonList) {

                            //update "paths" swagger object with pathItems relevant to current singleton
                            PathMapper.mapPathItems(singleton);

                            //----Annotation------

                            List<Annotation> singletonAnnotationList = singleton.getAnnotationList();

                            //update "tags" array of the "swagger" object
                            swaggerSpecGenerator.updateTags(singleton.getName(), annotationList);
                        }

                    }


                    //----ActionImports-----

                    List<TActionImport> actionImportList = entityContainer.getActionImportList();

                    if(actionImportList != null){

                        for(TActionImport actionImport: actionImportList){

                            //add action import to swagger specification
                            PathMapper.mapActionImports(actionImport);
                        }
                    }


                    //----FunctionImports-----

                    List<TFunctionImport> functionImportList = entityContainer.getFunctionImportList();

                    if( functionImportList != null){

                        for(TFunctionImport functionImport: functionImportList){

                            //add function import to swagger specification
                            PathMapper.mapFunctionImports(functionImport);
                        }
                    }


                }


                //----Map Bound Actions and Bound Functions

                if(functionList != null) {
                    for (TFunction function : functionList) {
                        //add necessary path items for current bound function
                        PathMapper.mapBoundFunction(function);
                    }
                }

                if(actionList != null) {
                    for (TAction action : actionList) {
                        //add necessary path items for current bound action
                        PathMapper.mapBoundAction(action);
                    }
                }




            }
        }

        swaggerSpecGenerator.generateSwaggerJsonObject(pathToSwaggerFile);

    }





    //methods to update fields of "info" swagger object
    public void updateInfoObject(List<Annotation> annotationList){

       if(annotationList!= null && annotationList.size()>0){
           for(Annotation annotation: annotationList){
               updateInfoObject(annotation);
           }
       }
    }

    public void updateInfoObject(Annotation annotation){
        Info info = Info.getInstance();

        if(info.getTitle() == "Open API specification for OData Service hosted at " + ServiceRoot.getInstance().getCurrentServiceRoot()) {
            String title = (String) AnnotationMapper.findAnnotationTerm(annotation, AnnotationMapper.CORE_DESCRIPTION);
            if (title != null) {
                info.setTitle(title);
            }
        }

        if(info.getVersion() == "*") {
            String version = (String) AnnotationMapper.findAnnotationTerm(annotation, AnnotationMapper.CORE_SCHEMA_VERSION);
            if (version != null) {
                info.setVersion(version);
            }
        }

        if(info.getDescription() == null) {
            String description = (String) AnnotationMapper.findAnnotationTerm(annotation, AnnotationMapper.CORE_LONG_DESCRIPTION);
            if (description != null) {
                info.setDescription(description);
            }
        }
    }





    //extract Supported Formats from the edm to create "consumes" and "produces" swagger json arrays
    public void updateConsumesAndProduces(List<Annotation> annotationList){

        SwaggerSpecGenerator swaggerSpecGenerator = new SwaggerSpecGenerator();

        if(annotationList != null && annotationList.size()>0 ){

            for (Annotation annotation: annotationList) {
                swaggerSpecGenerator.updateConsumesAndProduces(annotation);
            }
        }
    }

    public void updateConsumesAndProduces(Annotation annotation){
        Swagger swagger = Swagger.getInstance();
        List<String> supportedFormats = (List<String>) AnnotationMapper.findAnnotationTerm(annotation, AnnotationMapper.CAPABILITIES_SUPPORTED_FORMATS);
        if(supportedFormats != null && supportedFormats.size()>0){
            for (String supportedFormat: supportedFormats){
                if(!swagger.getConsumes().contains(supportedFormat)){
                    swagger.addConsumeType(supportedFormat);
                    swagger.addProduceType(supportedFormat);
                }
            }
        }
    }




    //method to add tags to the "tags" swagger object
    public void updateTags(String tagName, List<Annotation> annotationList){

        String tagDescription = (String) AnnotationMapper.findAnnotationTerm(annotationList, AnnotationMapper.CORE_DESCRIPTION);

        if(tagName != null) {
            Tag tag = new Tag(tagName);
            if(tagDescription != null){
                tag.setDescription(tagDescription);
            }
            Swagger.getInstance().addTag(tag);
        }

    }




    //method which add root level swagger objects to the "swagger" object
    public void finalizeSwaggerMapping(){
        Swagger swagger = Swagger.getInstance();
        swagger.addTag(new Tag("Action Imports"));
        swagger.addTag(new Tag("Function Imports"));
        swagger.addTag(new Tag("Bound Actions"));
        swagger.addTag(new Tag("Bound Functions"));
    }



    //method which generates swagger json object
    public void generateSwaggerJsonObject(String pathToSwaggerFile){
        finalizeSwaggerMapping();

        JsonObject swaggerJsonObject = SwaggerObjectBuilder.createSwaggerObject(Swagger.getInstance());

        WriteJsonToFile.write(swaggerJsonObject, pathToSwaggerFile);
    }




    //method to get a specified model from models hashMap
    public static Object getModel(String key){
        return models.get(key);
    }

    //method to get a entity model of a particular entity set
    public static String getEntityType(String entitySetName){
        return entitySets.get(entitySetName);
    }



}
