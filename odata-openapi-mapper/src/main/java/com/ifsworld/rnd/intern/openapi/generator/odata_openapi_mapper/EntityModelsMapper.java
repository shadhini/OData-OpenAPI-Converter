package com.ifsworld.rnd.intern.openapi.generator.odata_openapi_mapper;

import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.*;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Schema;


import java.util.List;

public class EntityModelsMapper {




    //this methods adds a corresponding definition to the swagger "definitions" object, when an EntityType is given
    public static void createDefinition(String namespace, TEntityType entityType){

        EntityModelsMapper entityModelsMapper = new EntityModelsMapper();

        Schema schema = entityModelsMapper.createSchema(entityType.getBaseType(), entityType.getAnnotationList(), entityType.getPropertyList(), entityType.getNavigationPropertyList());

        String description = schema.getDescription();
        if(description == null){
            schema.setDescription("Entity Type");
        }else{
            schema.setDescription("Entity Type: " + description);
        }

        Definitions.getInstance().addDefinition(namespace + "." + entityType.getName(),schema);
    }



    //this method adds corresponding definition to the "definitions" swagger object, when a ComplexType is given
    public static void createDefinition(String namespace, TComplexType complexType){

        EntityModelsMapper entityModelsMapper = new EntityModelsMapper();

        Schema schema = entityModelsMapper.createSchema(complexType.getBaseType(), complexType.getAnnotationList(), complexType.getPropertyList(), complexType.getNavigationPropertyList());

        String description = schema.getDescription();

        if(description == null){
            schema.setDescription("Complex Type");
        }else {
            schema.setDescription("Complex Type: " + description);
        }


        Definitions.getInstance().addDefinition(namespace+"."+complexType.getName(), schema);

    }



    //this method adds corresponding definition to the "definitions" swagger object, when EnumType is given.
    public static void createDefinition(String namespace, TEnumType enumType){

        SingleSchema singleSchema = new SingleSchema();

        //set the description of single schema
        String description = (String) AnnotationMapper.findAnnotationTerm(enumType.getAnnotationList(), AnnotationMapper.CORE_DESCRIPTION);
        if(description != null){
            singleSchema.setDescription("Enum Type: " + description);
        }else {
            singleSchema.setDescription("Enum Type");
        }

        Type type = TypeMapper.createType("Edm.String");

        List<TEnumTypeMember> memberList = enumType.getMemberList();

        if(memberList != null && memberList.size()>0) {

            for(TEnumTypeMember member: memberList) {

                //add enum members to the single schema
                type.addEnumMember(member.getName());
            }

        }

        singleSchema.setTypeOrReference(type);

        Definitions.getInstance().addDefinition(namespace + "." + enumType.getName(),singleSchema);

    }


    //method to create a swagger property, when propertyName, EntityType and Annotation list are provided
    public Property createSwaggerProperty(String edmPropertyName, String edmType, String description){

        Property swaggerProperty =  new Property(edmPropertyName);

        //mapping collection valued structural properties to swagger properties
        if(edmType.matches("Collection" + ".*")){

            SingleSchema propertySchema = TypeMapper.mapPrimitiveProperties(SwaggerKeys.ARRAY);

            Type_Array array = (Type_Array) propertySchema.getTypeOrReference();

            //mapping collection-valued primitive structural properties to swagger properties
            if(edmType.split("\\(")[1].matches("Edm."+".*")){
                array.getValue().setItems(new Items(TypeMapper.createType(edmType.split("\\(")[1].split("\\)")[0])));
            }
            //mapping collection-valued complex structural properties to swagger properties
            else {
                array.getValue().setItems(new Items(new Reference(edmType.split("\\(")[1].split("\\)")[0], Reference.RELATIVE_TO_DEFINITIONS)));
            }

            swaggerProperty.setSchemaOrReference(propertySchema);
        }

        //mapping primitive edm structural properties and navigation properties to swagger properties
        else if(edmType.matches("Edm." + ".*" )){
            swaggerProperty.setSchemaOrReference(TypeMapper.mapPrimitiveProperties(edmType));
        }

        //mapping complex edm structural properties and navigation properties to swagger properties
        else{
            swaggerProperty.setSchemaOrReference(new Reference(edmType,Reference.RELATIVE_TO_DEFINITIONS));
        }

        if(description != null){
            if(swaggerProperty.getSchemaOrReference() instanceof Schema){
                ((Schema)swaggerProperty.getSchemaOrReference()).setDescription(description);
            }
        }

        return swaggerProperty;
    }


    //this method returns corresponding swagger "Property" object for a given EDM Property
    public Property createSwaggerProperty(TProperty edmProperty){

        EntityModelsMapper entityModelsMapper = new EntityModelsMapper();

        //extract the description for swagger property
        String description = (String) AnnotationMapper.findAnnotationTerm(edmProperty.getAnnotation(), AnnotationMapper.CORE_DESCRIPTION);

        return entityModelsMapper.createSwaggerProperty(edmProperty.getName(), edmProperty.getType().get(0), description);
    }


    //this method returns corresponding swagger "Property" object for a given EDM NavigationProperty
    public Property createSwaggerProperty(TNavigationProperty navigationProperty){

        EntityModelsMapper entityModelsMapper = new EntityModelsMapper();

        //extract the description for swagger property
        String description = (String)AnnotationMapper.findAnnotationTerm(navigationProperty.getAnnotationList(), AnnotationMapper.CORE_DESCRIPTION);

        return entityModelsMapper.createSwaggerProperty(navigationProperty.getName(), navigationProperty.getType().get(0),description);
    }

    //this method returns corresponding swagger "Property" object for a given EDM Parameter
    public static Property createSwaggerProperty(TActionFunctionParameter parameter){

        EntityModelsMapper entityModelsMapper = new EntityModelsMapper();

        //extract the description for swagger property
        String description = (String) AnnotationMapper.findAnnotationTerm(parameter.getAnnotation(), AnnotationMapper.CORE_DESCRIPTION);

        return entityModelsMapper.createSwaggerProperty(parameter.getName(), parameter.getType().get(0), description);
    }



    //creates "Schema" swagger object for entity models, when baseType and child elements of the EntityType/ComplexType is provided
    public Schema createSchema(String baseType, List<Annotation> annotationList, List<TProperty> propertyList, List<TNavigationProperty> navigationPropertyList){

        EntityModelsMapper entityModelsMapper =  new EntityModelsMapper();

        //creating simple schema for object. If current EntityType/ComplexType is a derived type of another base type, this schema object will be added to the allOf array together with the baseType Schema.
        SingleSchema simpleSchema = TypeMapper.mapPrimitiveProperties(SwaggerKeys.OBJECT) ;

        //set simple schema description, if available
        String description = (String) AnnotationMapper.findAnnotationTerm(annotationList, AnnotationMapper.CORE_DESCRIPTION);
        if (description != null) {
            simpleSchema.setDescription(description);
        }

        Type_Object object = (Type_Object) simpleSchema.getTypeOrReference();


        if(propertyList != null && propertyList.size()>0){

            for(TProperty property: propertyList) {
                //add properties to the "object" of the simple schema
                object.getValue().addProperty((entityModelsMapper.createSwaggerProperty(property)));
            }
        }

        if(navigationPropertyList != null && navigationPropertyList.size()>0){

            for(TNavigationProperty navigationProperty: navigationPropertyList){
                //add navigation properties to the "object" of the simple schema
                object.getValue().addProperty(entityModelsMapper.createSwaggerProperty(navigationProperty));
            }
        }


        //for structured types with base type
        if(baseType != null){

            //initializing schema object for definition
            MultipleSchema schema = new MultipleSchema();

            //add the reference object for the base type to the allOf array of definition schema
            schema.addToAllOf(new Reference(baseType,Reference.RELATIVE_TO_DEFINITIONS));


            //add the derived schema (i.e. simple schema) to "allOf" array of the definition schema
            schema.addToAllOf(simpleSchema);

            return schema;

        }
        //for structured types without base type
        else {

            return simpleSchema;
        }

    }





}
