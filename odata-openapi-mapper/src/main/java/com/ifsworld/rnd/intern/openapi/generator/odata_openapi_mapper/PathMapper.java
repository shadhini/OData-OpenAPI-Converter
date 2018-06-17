package com.ifsworld.rnd.intern.openapi.generator.odata_openapi_mapper;

import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.http_methods.*;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class PathMapper {


    private static HashMap<String, String> complexPaths = new HashMap<>();

    //maps all possible operations for an EntitySet to a PathItem/PathItems and add them to "Paths" swagger object
    public static void mapPathItems(TEntitySet entitySet, TEntityType entityType){

        PathMapper pathMapper = new PathMapper();

        //create http operations for an entity set
        if(entitySet != null) {
            PathItem pathItem = new PathItem();

            //GET operation for an entity set
            Get get = pathMapper.createGetForEntitySet(entitySet);
            pathItem.setGet(get);

            //POST operation to create an entity
            Post post = pathMapper.createPostForEntitySet(entitySet);
            pathItem.setPost(post);

            Paths.getInstance().addPath(entitySet.getName(),pathItem);

        }

        //create path template for an individual entity within an entity set
        if(entityType != null && entityType.getKeyElement() != null ){
            PathItem pathItem = null;
            String pathName = null;

            //single-part key
            if(entityType.getKeyElement().getPropertyRef() != null && entityType.getKeyElement().getPropertyRef().size()==1) {
                pathItem = new PathItem();
                pathName = entitySet.getName() + "({" + entityType.getKeyElement().getPropertyRef().get(0).getName() + "})";

                complexPaths.put(entitySet.getEntityType(), pathName);
            }

            //multi-part key
            else if(entityType.getKeyElement().getPropertyRef() != null && entityType.getKeyElement().getPropertyRef().size()>1){
                pathName = entitySet.getName() + "(" ;
                for(TPropertyRef propertyRef: entityType.getKeyElement().getPropertyRef()) {
                    pathName = pathName + propertyRef.getName() + "={" + propertyRef.getName() + "},";
                }
                pathName = pathName.substring(0, pathName.length()-1) + ")" ;

                complexPaths.put(entitySet.getEntityType(), pathName);
                pathItem = new PathItem();
            }


            if(pathItem != null) {
                //GET operation to retrieve an individual entity
                Get get = pathMapper.createGetForSingleEntity(entitySet);
                pathItem.setGet(get);

                //PATCH operation to update an individual entity
                Patch patch = pathMapper.createPatchForSingleEntity(entitySet);
                pathItem.setPatch(patch);

                //DELETE operation to delete an individual entity
                Delete delete = pathMapper.createDeleteForSingleEntity(entitySet);
                pathItem.setDelete(delete);

                Paths.getInstance().addPath(pathName,pathItem);
            }
        }

    }


    //maps all possible operations for a Singleton to a PathItem/PathItems and add them to "Paths" swagger object
    public static void mapPathItems(TSingleton singleton){

        PathMapper pathMapper = new PathMapper();

        if(singleton != null){
            PathItem pathItem = new PathItem();

            //GET operation to retrieve a Singleton
            Get get = pathMapper.createGetForSingleton(singleton);
            pathItem.setGet(get);

            //PATCH operation to update a Singleton
            Patch patch = pathMapper.createPatchForSingleton(singleton);
            pathItem.setPatch(patch);

            Paths.getInstance().addPath(singleton.getName(), pathItem);
        }

    }



    //this method creates GET operation for an Entity Set to query a collection of entities
    public Get createGetForEntitySet(TEntitySet entitySet){

        Get get = new Get();

        //set summary
        get.setSummary("Get entities from " + entitySet.getName());


        //------------creation of response for HTTP status code 200
        //creating response
        Response response200 = new Response("Retrieved entities");

        //set Schema of the "response"
        SingleSchema schema = TypeMapper.mapPrimitiveProperties("object");
        String[] entityTypeName = entitySet.getEntityType().split("\\.");
        if(entityTypeName.length > 0) {
            schema.setTitle("Collection of " + entityTypeName[entityTypeName.length - 1] + "s");
        }

        SingleSchema propertySchema = TypeMapper.mapPrimitiveProperties("array");
        ((Type_Array)propertySchema.getTypeOrReference()).getValue().setItems(new Items(new Reference(entitySet.getEntityType(), Reference.RELATIVE_TO_DEFINITIONS)));
        Property property = new Property("value", propertySchema);

        ((Type_Object)schema.getTypeOrReference()).getValue().addProperty(property);

        response200.setSchema(schema);
        //----------------------------------------------------------------



        //set "responses" field
        Responses responses = new Responses();

        responses.addResponse("200", response200);
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        get.setResponses(responses);


        //add tags
        get.addTag(entitySet.getName());

        return get;
    }




    //this method creates GET operation for an individual entity to retrieve an entity
    public Get createGetForSingleEntity(TEntitySet entitySet){

        PathMapper pathMapper = new PathMapper();

        Get get = new Get();

        //set summary
        get.setSummary("Get entity from " + entitySet.getName() + " by key");

        //set parameters
        get.setParameters(pathMapper.createPathParameters((TEntityType) SwaggerSpecGenerator.getModel(entitySet.getEntityType())));


        //------------creation of response for HTTP status code 200
        Response response200 = new Response("Retrieved entity",
                new SingleSchema(new Reference(entitySet.getEntityType(), Reference.RELATIVE_TO_DEFINITIONS)));
        //-----------------------------------------------------------

        //set responses
        Responses responses = new Responses();
        responses.addResponse("200",response200);
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        get.setResponses(responses);

        //add tags
        get.addTag(entitySet.getName());

        return get;
    }





    //this method creates POST operation for an Entity Set to create an entity
    public Post createPostForEntitySet(TEntitySet entitySet){

        PathMapper pathMapper = new PathMapper();

        Post post = new Post();

        //set summary
        post.setSummary("Add new entity to " + entitySet.getName());








        //set the parameters
        post.addParameter(pathMapper.createBodyParameter(entitySet.getEntityType().split("\\.")[entitySet.getEntityType().split("\\.").length - 1],entitySet.getEntityType(), "New Entity"));


        //---------------creation of response for HTTP status code 201
        Response response201 = new Response("Created Entity",
                new SingleSchema(new Reference(entitySet.getEntityType(),Reference.RELATIVE_TO_DEFINITIONS)));
        //---------------------------------------------------


        //set the responses
        Responses responses =  new Responses();
        responses.addResponse("201",response201);
        //if the service supports the preference return=minimal
        responses.addResponse("204", new Response("No Content"));
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        post.setResponses(responses);

        //add tags
        post.addTag(entitySet.getName());

        return post;
    }



    //this method creates PATCH operation for an individual entity to update an entity
    public Patch createPatchForSingleEntity(TEntitySet entitySet){

        PathMapper pathMapper =  new PathMapper();

        Patch patch = new Patch();

        //set summary
        patch.setSummary("Update entity in " + entitySet.getName());

        //set parameters
        //set path parameters
        patch.setParameters(pathMapper.createPathParameters((TEntityType) SwaggerSpecGenerator.getModel(entitySet.getEntityType())));
        //set body parameters
        patch.addParameter(pathMapper.createBodyParameter(entitySet.getName().substring(0,entitySet.getName().length()-1), entitySet.getEntityType(), "New property values"));


        //--------creation of response for HTTP status code 200
        //if the service supports the preference return=representation
        Response response200 =  new Response("OK",
                new SingleSchema(new Reference(entitySet.getEntityType(), Reference.RELATIVE_TO_DEFINITIONS)));
        //------------------------------------------------------

        //set responses
        Responses responses =  new Responses();
        responses.addResponse("204", new Response("Success"));
        responses.addResponse("200", response200);
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        patch.setResponses(responses);

        //add tag
        patch.addTag(entitySet.getName());

        return patch;
    }


    //this method returns DELETE operation for an individual entity to delete an entity
    public Delete createDeleteForSingleEntity(TEntitySet entitySet){

        PathMapper pathMapper = new PathMapper();

        Delete delete = new Delete();

        //set summary
        delete.setSummary("Delete entity from " + entitySet.getName());

        //set parameters
        //set path parameters
        delete.setParameters(pathMapper.createPathParameters((TEntityType) SwaggerSpecGenerator.getModel(entitySet.getEntityType())));
        //set header parameters
        NonBodyParameter nonBodyParameter = new NonBodyParameter();
        nonBodyParameter.setName("If-Match");
        nonBodyParameter.setIn(Parameter.IN_HEADER);
        nonBodyParameter.setDescription("ETag");
        nonBodyParameter.setType(TypeMapper.createType("Edm.String"));
        delete.addParameter(nonBodyParameter);

        //set responses
        Responses responses =  new Responses();
        responses.addResponse("204", new Response("Success"));
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        delete.setResponses(responses);

        //add tags
        delete.addTag(entitySet.getName());

        return delete;
    }

    //this method creates GET operation for a Singleton to retrieve a Singleton
    public Get createGetForSingleton(TSingleton singleton){

        Get get = new Get();

        //set summary
        get.setSummary("Get " + singleton.getName());

        //set responses
        Responses responses = new Responses();
        responses.addResponse("200", new Response("Retrieved entity",
                new SingleSchema(new Reference(singleton.getType(),Reference.RELATIVE_TO_DEFINITIONS)) ));
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        get.setResponses(responses);

        //add tags
        get.addTag(singleton.getName());


        return get;
    }





    //this method creates PATCH operation for a Singleton to update a Singleton
    public Patch createPatchForSingleton(TSingleton singleton){

        PathMapper pathMapper = new PathMapper();

        Patch patch = new Patch();

        //set summary
        patch.setSummary("Update " + singleton.getName());

        //set parameters
        patch.addParameter(pathMapper.createBodyParameter(singleton.getType().substring(singleton.getType().lastIndexOf(".")+1, singleton.getType().length()), singleton.getType(), "New property values"));

        //set responses
        Responses responses = new Responses();
        responses.addResponse("204",new Response("Success") );
        //if the service supports the preference return = representation
        responses.addResponse("200", new Response("OK",
                new SingleSchema(new Reference(singleton.getType(),Reference.RELATIVE_TO_DEFINITIONS)) ));
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));


        //add tags
        patch.addTag(singleton.getName());

        return patch;
    }



    //maps action import to corresponding swagger "pathItem"s
    public static void mapActionImports(TActionImport actionImport){

        PathMapper pathMapper = new PathMapper();

        PathItem pathItem = new PathItem();

        Post post = new Post();

        //set summary
        post.setSummary("Invoke action " + actionImport.getName());

        // set body parameters
        post.addParameter(pathMapper.createBodyParameter(((TAction) SwaggerSpecGenerator.getModel(actionImport.getAction())).getParameterList()));

        //create responses
        Responses responses = new Responses();
        responses.addResponse("204", new Response("Success"));
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));


        if(actionImport.getEntitySet() != null) {

            //add new response
            responses.addResponse("200", new Response("OK",
                    new SingleSchema(new Reference(SwaggerSpecGenerator.getEntityType(actionImport.getEntitySet()),Reference.RELATIVE_TO_DEFINITIONS)) ));

       }

        //set responses
        post.setResponses(responses);

        //add tags
        post.addTag("Action Imports");

        pathItem.setPost(post);

        //add new pathItem to "Paths" swagger object
        Paths.getInstance().addPath(actionImport.getName(),pathItem);

    }


    //maps function import to corresponding swagger "pathItem"s
    public static void mapFunctionImports(TFunctionImport functionImport){

        PathMapper pathMapper = new PathMapper();

        PathItem pathItem = new PathItem();

        String pathName;

        TFunction function = ((TFunction)SwaggerSpecGenerator.getModel(functionImport.getFunction()));

        Get get = new Get();

        //set summary
        get.setSummary("Invoke function " + functionImport.getName());

        //set parameters
        //set path parameters--------------------------------------------------------------------------------------
        List<TActionFunctionParameter> functionParameters = function.getParameterList();

        pathName = function.getName();

        if(functionParameters != null && functionParameters.size()>0){
            get.setParameters(pathMapper.createParametersForFunction(functionParameters));
            pathName = pathMapper.createPathTemplateForFunctionWithParameters(pathName, functionParameters);
        }



        //set responses
        Responses responses = new Responses();
        if(functionImport.getEntitySet() != null) {
            responses.addResponse("200", new Response("Success",
                    new SingleSchema(new Reference(SwaggerSpecGenerator.getEntityType(functionImport.getEntitySet()),Reference.RELATIVE_TO_DEFINITIONS)) ));
        }else {
            responses.addResponse("200", new Response("Success"));
        }
        responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

        get.setResponses(responses);


        //add tags
        get.addTag("Function Imports");

        pathItem.setGet(get);


        Paths.getInstance().addPath(pathName, pathItem);

    }

    //this method maps a bound action to corresponding pathItem s
    public static void mapBoundAction(TAction action){

        PathMapper pathMapper = new PathMapper();

        PathItem pathItem = new PathItem();

        String pathName = "";

        if(action.isIsBound()){

            Post post = new Post();

            List<TActionFunctionParameter> parameterList = action.getParameterList();

            //set summary
            post.setSummary("Invoke action " + action.getName());

            //set parameters
            if(parameterList != null && parameterList.size()>0){

                //set path parameters
                String boundParameterType = parameterList.get(0).getType().get(0);
                if(!(boundParameterType.matches("Edm."+ ".*") || boundParameterType.matches("Collection" + ".*"))){
                    post.setParameters(pathMapper.createPathParameters((TEntityType) SwaggerSpecGenerator.getModel(boundParameterType)));
                    pathName = pathName + getComplexPaths(boundParameterType) + "/";
                }

                //set body parameters
                parameterList.remove(0);
                post.addParameter(pathMapper.createBodyParameter(parameterList));
            }

            //set Responses
            Responses responses = new Responses();
//            responses.addResponse("201", new Response("Created",
//                    new SingleSchema(new Reference(SwaggerSpecGenerator.getEntityType(action.ge),Reference.RELATIVE_TO_DEFINITIONS)) ));
            responses.addResponse("204", new Response("Success"));
            responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

            post.setResponses(responses);


            //add tags
            post.addTag("Bound Actions");

            pathItem.setPost(post);

            if(!pathName.contains("null")) {
                Paths.getInstance().addPath(pathName + action.getName(), pathItem);
            }

        }
    }

    //this method maps a bound function to corresponding pathItem s
    public static void mapBoundFunction(TFunction function){

        PathMapper pathMapper = new PathMapper();

        PathItem pathItem = new PathItem();


        String pathName = "";

        if(function.isIsBound()){

            Get get = new Get();

            List<TActionFunctionParameter> parameterList = function.getParameterList();

            //set summary
            get.setSummary("Invoke function " + function.getName());

            //set parameters
            //set path parameters
            if(parameterList != null && parameterList.size()>0){

                String boundParameterType = parameterList.get(0).getType().get(0);

                TEntityType entityModel = (TEntityType) SwaggerSpecGenerator.getModel(boundParameterType);

                if(entityModel != null) {

                    get.setParameters(pathMapper.createPathParameters((TEntityType) SwaggerSpecGenerator.getModel(boundParameterType)));

                    if (getComplexPaths(boundParameterType) != null) {
                        System.out.println(getComplexPaths(boundParameterType));
                        pathName = pathName + getComplexPaths(boundParameterType);
                    } else {
                        if (function.getEntitySetPath() != null) { //in case the function is bound to a entity type that should be accessed through a navigation
                            pathName = pathMapper.cretePathTemplateForBoundFunction(function.getEntitySetPath(), entityModel.getKeyElement());
                        }
                    }
                }

                parameterList.remove(0);


                if(parameterList.size() > 0) {

                    List<TActionFunctionParameter> functionParameters = function.getParameterList();

                    pathName = pathName + function.getName();

                    if(functionParameters != null && functionParameters.size()>0){
                        get.setParameters(pathMapper.createParametersForFunction(functionParameters));
                        pathName = pathMapper.createPathTemplateForFunctionWithParameters(pathName, functionParameters);
                    }

                }
                else {
                    pathName = pathName + "/" + function.getName();
                }
            }

            //set Responses
            Responses responses = new Responses();
            responses.addResponse("204", new Response("Success"));
            responses.addResponse("default", new Reference("undocumented", Reference.RELATIVE_TO_RESPONSES));

            get.setResponses(responses);

            //add tags
            get.addTag("Bound Functions");


            pathItem.setGet(get);


            Paths.getInstance().addPath(pathName, pathItem);


        }
    }


    //method to create path parameters for the current path for a given EntityType
    public List<IParameter> createPathParameters(TEntityType entityType){

        List<IParameter> parameters = null;
        HashMap<String, TProperty> propertyHashMap = new HashMap<>();


        if(entityType.getKeyElement() != null && entityType.getKeyElement().getPropertyRef() != null && entityType.getKeyElement().getPropertyRef().size()>0) {

            for(TProperty edmProperty: entityType.getPropertyList()){
                propertyHashMap.put(edmProperty.getName(), edmProperty);
            }

            parameters =  new ArrayList<>();
            List<TPropertyRef> propertyRefs = entityType.getKeyElement().getPropertyRef();
            for(TPropertyRef propertyRef : propertyRefs){
                NonBodyParameter parameter =  new NonBodyParameter();
                parameter.setName(propertyRef.getName());
                parameter.setIn(Parameter.IN_PATH);
                parameter.setRequired(true);

                String description = (String) AnnotationMapper.findAnnotationTerm(propertyHashMap.get(propertyRef.getName()).getAnnotation(), AnnotationMapper.CORE_DESCRIPTION);
                if(description != null) {
                    parameter.setDescription("key : " + propertyRef.getName() + "-" + description);
                }
                parameter.setDescription("key : " + propertyRef.getName());

                parameter.setType(TypeMapper.createType(propertyHashMap.get(propertyRef.getName()).getType().get(0)));

                parameters.add(parameter);
            }
        }

        return parameters;
    }





    //this method create a BodyParameter which reference to a schema defined in global definitions, when the required data is given
    public BodyParameter createBodyParameter(String name, String entityType, String description){

        BodyParameter bodyParameter = new BodyParameter();

        bodyParameter.setName(name);
        bodyParameter.setDescription(description);
        bodyParameter.setSchema(new SingleSchema(new Reference(entityType,Reference.RELATIVE_TO_DEFINITIONS)));

        return bodyParameter;
    }

    //this method create a corresponding BodyParameter for a given parameter list of an Action
    public BodyParameter createBodyParameter(List<TActionFunctionParameter> parameterList){


        BodyParameter bodyParameter = new BodyParameter();

        bodyParameter.setName("body");
        bodyParameter.setDescription("Action parameters");

        SingleSchema schema = TypeMapper.mapPrimitiveProperties("object");
        OBJECT object = ((Type_Object) schema.getTypeOrReference()).getValue();

        if(parameterList != null && parameterList.size()>0) {
            for(TActionFunctionParameter parameter: parameterList) {
                object.addProperty(EntityModelsMapper.createSwaggerProperty(parameter));
            }
        }

        bodyParameter.setSchema(schema);

        return bodyParameter;
    }




    public List<IParameter> createParametersForFunction(List<TActionFunctionParameter> parameters){

        PathMapper pathMapper = new PathMapper();

        List<IParameter> parameterList = new ArrayList<>();
        //mapping additional parameters
        for(TActionFunctionParameter parameter: parameters){

            if(parameter.getType().get(0).matches("Edm." + ".*" )){
                //creating a path parameter for the current additional parameter
                parameterList.add(pathMapper.createPathParameter(parameter));
            }else {
                //creating query parameter for the current additional parameter which is of complex type
                parameterList.add(pathMapper.createQueryParameterForFunction(parameter));
            }
        }

        return parameterList;
    }


    public NonBodyParameter createPathParameter(TActionFunctionParameter parameter){

        NonBodyParameter nonBodyParameter = new NonBodyParameter();
        nonBodyParameter.setName(parameter.getName());
        nonBodyParameter.setIn(Parameter.IN_PATH);
        nonBodyParameter.setRequired(true);

        String description = (String) AnnotationMapper.findAnnotationTerm(parameter.getAnnotation(), AnnotationMapper.CORE_DESCRIPTION);
        if(description != null){
            nonBodyParameter.setDescription(description);
        }

        nonBodyParameter.setType(TypeMapper.createType(parameter.getType().get(0)));

        return nonBodyParameter;
    }

    //this method creates query parameters for functions
    public NonBodyParameter createQueryParameterForFunction(TActionFunctionParameter parameter){

        NonBodyParameter nonBodyParameter = new NonBodyParameter();

        nonBodyParameter.setName("$" + parameter.getName());
        nonBodyParameter.setIn(Parameter.IN_QUERY);

        String dataType =  parameter.getType().get(0);

        if (dataType.matches("Collection" + ".*")) {

            Type_Array type_array = (Type_Array) TypeMapper.createType("array");

            if (dataType.split("\\(")[1].matches("Edm."+".*")) {

                type_array.getValue().setItems(new Items(TypeMapper.createType(dataType.split("\\(")[1].split("\\)")[0])));

            }else {

                type_array.getValue().setItems(new Items(TypeMapper.createType("STRING")));
            }

            nonBodyParameter.setType(type_array);

        }else if (SwaggerSpecGenerator.getModel(parameter.getType().get(0)) instanceof  TEnumType){

            TEnumType enumType = (TEnumType) SwaggerSpecGenerator.getModel(parameter.getType().get(0));

            Type_String type = (Type_String) TypeMapper.createType("STRING");
            for (TEnumTypeMember member : enumType.getMemberList()) {
                type.addEnumMember(member.getName());
            }

            nonBodyParameter.setType(type);

        }else {

            nonBodyParameter.setType(TypeMapper.createType("STRING"));
        }

        return  nonBodyParameter;
    }

    public String createPathTemplateForFunctionWithParameters(String initialPath, List<TActionFunctionParameter> parameters){

        List<String> additionalPathParameters = new ArrayList<>();
        String pathToResource = initialPath;

        for(TActionFunctionParameter parameter: parameters){

            if(parameter.getType().get(0).matches("Edm." + ".*" )) {
                //update additionalPathParameters list
                additionalPathParameters.add(parameter.getName());
            }
        }

        if(additionalPathParameters.size()>0){
            pathToResource = pathToResource + "(" ;
            for(String parameterName : additionalPathParameters){
                pathToResource = pathToResource + parameterName + "={" + parameterName + "}," ;
            }

            pathToResource = pathToResource.substring(0, pathToResource.length()-1) + ")";
        }

        return pathToResource;
    }

    public String cretePathTemplateForBoundFunction(String initialPath, TEntityKeyElement keyElement){

        String path = initialPath;

        if(keyElement != null && keyElement.getPropertyRef() != null && keyElement.getPropertyRef().size()>0) {

            path = path + "(";

            List<TPropertyRef> propertyRefs = keyElement.getPropertyRef();
            for(TPropertyRef propertyRef : propertyRefs){
                path = path + propertyRef.getName() + "={" + propertyRef.getName() + "}," ;
            }

            path = path.substring(0, path.length()-1) + ")";
        }

        return path;
    }


//    //this method create path template to access a single entity for a given EntityType
//    public String createPathTemplateToAccessSingleEntity(TEntityType entityType){
//
//        //create path template for an individual entity within an entity set
//        if(entityType != null && entityType.getKeyElement() != null ){
//            PathItem pathItem = null;
//            String pathName = null;
//
//            //single-part key
//            if(entityType.getKeyElement().getPropertyRef() != null && entityType.getKeyElement().getPropertyRef().size()==1) {
//                pathItem = new PathItem();
//                pathName = entitySet.getName() + "({" + entityType.getKeyElement().getPropertyRef().get(0).getName() + "})";
//
//                complexPaths.put(entitySet.getEntityType(), pathName);
//            }
//
//            //multi-part key
//            else if(entityType.getKeyElement().getPropertyRef() != null && entityType.getKeyElement().getPropertyRef().size()>1){
//                pathName = entitySet.getName() + "(" ;
//                for(TPropertyRef propertyRef: entityType.getKeyElement().getPropertyRef()) {
//                    pathName = pathName + propertyRef.getName() + "={" + propertyRef.getName() + "},";
//                }
//                pathName = pathName.substring(0, pathName.length()-1) + ")" ;
//
//                complexPaths.put(entitySet.getEntityType(), pathName);
//                pathItem = new PathItem();
//            }
//
//    }


    //method to get paths with all query parameters when the EntityType is provided
    public static String getComplexPaths(String key) {
        return complexPaths.get(key);
    }

}
