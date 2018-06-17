package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.JsonUtils;
import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class SchemaObjectBuilder {

    public static JsonObject createSchemaObject(JsonObjectBuilder jsonObjectBuilder,ISchema iSchema) {

        if (jsonObjectBuilder == null) {
            jsonObjectBuilder = Json.createObjectBuilder();
        }


        if(iSchema != null) {
            //Schema
            if(iSchema instanceof Schema) {

                Schema schema = (Schema) iSchema;

                if(schema.getTitle() != null){
                    jsonObjectBuilder.add(SwaggerKeys.TITLE, schema.getTitle() );
                }

                if(schema.getDescription() != null){
                    jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, schema.getDescription());
                }

                if(schema.getDiscriminator() != null){
                    jsonObjectBuilder.add(SwaggerKeys.DISCRIMINATOR, schema.getDiscriminator());
                }

                //only for properties schemas
                if(schema.getReadOnly() == true){
                    jsonObjectBuilder.add(SwaggerKeys.READ_ONLY, schema.getReadOnly());
                }

                //only for properties schemas
                if(schema.getXml() != null){
                    jsonObjectBuilder.add(SwaggerKeys.XML, createXmlObject(schema.getXml()));
                }

                if(schema.getExternalDoc() != null){
                    jsonObjectBuilder.add(SwaggerKeys.EXTERNAL_DOCS, ExternalDocumentationObjectBuilder.createExternalDocsObject(schema.getExternalDoc()));
                }

                if(schema.getExample() != null){
                    //yet to implement and think how to do this????????????????????????????????????????????
                }

                //MultipleSchema
                if (iSchema instanceof MultipleSchema) {

                    MultipleSchema multipleSchema = (MultipleSchema) iSchema;

                    if (multipleSchema.getAllOf() != null && multipleSchema.getAllOf().size() > 0) {

                        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

                        for (ISchema item : multipleSchema.getAllOf()) {
                            jsonArrayBuilder.add(createSchemaObject(null, item));
                        }

                        jsonObjectBuilder.add(SwaggerKeys.ALL_OF, jsonArrayBuilder.build());

                    }

                    return jsonObjectBuilder.build();

                }
                //SingleSchema
                else if (iSchema instanceof SingleSchema) {

                    SingleSchema singleSchema = (SingleSchema) iSchema;

                    return createTypeObject(jsonObjectBuilder, singleSchema.getTypeOrReference());

                }
            }
            //Reference
            else if (iSchema instanceof Reference) {

                jsonObjectBuilder.add(SwaggerKeys.REFERENCE, ((Reference) iSchema).getReference());

                return jsonObjectBuilder.build();
            }

        }

        return jsonObjectBuilder.build();

    }



    public static JsonObject createTypeObject(JsonObjectBuilder jsonObjectBuilder, IType iType){

        if (jsonObjectBuilder == null) {
            jsonObjectBuilder = Json.createObjectBuilder();
        }

        if(iType instanceof Type) {

            Type type = (Type) iType;


            String typeName = type.getTypeName();
            jsonObjectBuilder.add(SwaggerKeys.TYPE, typeName);

            if (type.getFormat() != null) {
                jsonObjectBuilder.add(SwaggerKeys.FORMAT, type.getFormat());
            }

            if (type.getEnums() != null && type.getEnums().size() > 0) {
                jsonObjectBuilder.add(SwaggerKeys.ENUM, JsonUtils.createJsonArray(type.getEnums()));
            }

            if (type.get_default() != null) {
                //yet to implement ???????????????????????????????????????????
            }


            //-----------type = object----------------------------------------------------------------------------------------------------------------------------------------------------------------
            if (typeName == SwaggerKeys.OBJECT) {
                Type_Object typeObject = (Type_Object) type;
                if (typeObject.getRequired() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.REQUIRED, JsonUtils.createJsonArray(typeObject.getRequired()));
                }

                OBJECT object = typeObject.getValue();
                if (object != null) {
                    if (object.getProperties().size() > 0) {
                        JsonObjectBuilder propertiesObjectBuilder = Json.createObjectBuilder();
                        for (Property property : object.getProperties()) {
                            propertiesObjectBuilder.add(property.getPropertyTitle(), SchemaObjectBuilder.createSchemaObject(null, property.getSchemaOrReference()));
                        }

                        jsonObjectBuilder.add(SwaggerKeys.PROPERTIES, propertiesObjectBuilder.build());
                    }

                    if (object.getAdditionalProperty() != null) {
                        jsonObjectBuilder.add(SwaggerKeys.ADDITIONAL_PROPERTIES, SchemaObjectBuilder.createSchemaObject(null, object.getAdditionalProperty().getSchemaOrReference()));
                    }

                    if (typeObject.getMaxProperties() != null) {
                        jsonObjectBuilder.add(SwaggerKeys.MAX_PROPERTIES, (Integer) typeObject.getMaxProperties());
                    }

                    if (typeObject.getMinProperties() != null) {
                        jsonObjectBuilder.add(SwaggerKeys.MIN_PROPERTIES, (Integer) typeObject.getMinProperties());
                    }

                    return jsonObjectBuilder.build();
                }


                //------------------------type = array--------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (typeName == SwaggerKeys.ARRAY) {

                System.out.println();
                Type_Array typeArray = (Type_Array) type;
                ARRAY array = typeArray.getValue();

                if (array.getItems() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.ITEMS, SchemaObjectBuilder.createTypeObject(null, array.getItems().getTypeOrReference()));
                }


                if (typeArray.getMaxItems() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MAX_ITEMS, (Integer) typeArray.getMaxItems());
                }

                if (typeArray.getMinItems() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MIN_ITEMS, (Integer) typeArray.getMinItems());
                }

                if(typeArray.getUniqueItems() != null){
                    jsonObjectBuilder.add(SwaggerKeys.UNIQUE_ITEMS, typeArray.getUniqueItems());
                }

                if(typeArray.getCollectionFormat() != null){
                    jsonObjectBuilder.add(SwaggerKeys.COLLECTION_FORMAT, typeArray.getCollectionFormat());
                }

                return jsonObjectBuilder.build();


                //----------------------type = string -------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (typeName == SwaggerKeys.STRING[0]) {

                Type_String typeString = (Type_String) type;


                if (typeString.getMaxLength() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MAX_LENGTH, (Integer) typeString.getMaxLength());
                }

                if (typeString.getMinLength() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MIN_LENGTH, (Integer) typeString.getMinLength());
                }

                if (typeString.getPattern() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.PATTERN, typeString.getPattern());
                }

                return jsonObjectBuilder.build();


                //----------------------------type = number/integer ------------------------------------------------------------------------------------------------------------------------------------------
            } else if (typeName == SwaggerKeys.INTEGER[0] || typeName == SwaggerKeys.FLOAT[0]) {

                Type_NumberOrInteger type_numberOrInteger = (Type_NumberOrInteger) type;

                if (type_numberOrInteger.getMultipleOf() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MULTIPLE_OF, (Double) type_numberOrInteger.getMultipleOf());
                }

                if (type_numberOrInteger.getMaximum() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MAXIMUM, (Double) type_numberOrInteger.getMaximum());
                    if (type_numberOrInteger.getExclusiveMaximum() != null) {
                        jsonObjectBuilder.add(SwaggerKeys.EXCLUSIVE_MAXIMUM, type_numberOrInteger.getExclusiveMaximum());
                    }
                }

                if (type_numberOrInteger.getMinimum() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.MINIMUM, (Double) type_numberOrInteger.getMinimum());
                    if (type_numberOrInteger.getExclusiveMinimum() != null) {
                        jsonObjectBuilder.add(SwaggerKeys.EXCLUSIVE_MINIMUM, type_numberOrInteger.getExclusiveMinimum());
                    }
                }

                return jsonObjectBuilder.build();
            }

        }else if(iType instanceof Reference){

            Reference reference = (Reference) iType;

            jsonObjectBuilder.add(SwaggerKeys.REFERENCE, reference.getReference());

        }


        //------------------------type = all ------------------------------------------------------------------------------
        return jsonObjectBuilder.build();
    }

    public static JsonObject createXmlObject(XML xml){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        if(xml.getName() != null){
            jsonObjectBuilder.add(SwaggerKeys.NAME, xml.getName());
        }

        if(xml.getNamespace() != null){
            jsonObjectBuilder.add(SwaggerKeys.NAMESPACE, xml.getNamespace());
        }

        if(xml.getPrefix() != null){
            jsonObjectBuilder.add(SwaggerKeys.PREFIX, xml.getPrefix());
        }

        if(xml.getAttribute() != null){
            jsonObjectBuilder.add(SwaggerKeys.ATTRIBUTE, xml.getAttribute());
        }

        if(xml.getWrapped() != null){
            jsonObjectBuilder.add(SwaggerKeys.WRAPPED, xml.getWrapped());
        }

        return  jsonObjectBuilder.build();
    }
}
