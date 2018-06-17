package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.ListUtils;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Parameter;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Response;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Schema;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Swagger;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.security.SecurityScheme;
import com.ifsworld.rnd.intern.openapi.generator.common.JsonUtils;
import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.HashMap;
import java.util.List;

public class SwaggerObjectBuilder {

    //method to create a valid Swagger JSON Object
    public static JsonObject createSwaggerObject(Swagger swagger){

        SwaggerObjectBuilder swaggerObjectBuilder = new SwaggerObjectBuilder();

        JsonObjectBuilder swaggerJsonObjectBuilder =  Json.createObjectBuilder();

        //following are the required fields for a valid swagger specification
        swaggerJsonObjectBuilder
                .add(SwaggerKeys.SWAGGGER, swagger.getSwagger())
                .add(SwaggerKeys.INFO, InfoObjectBuilder.createInfoObject(swagger.getInfo()))
                .add(SwaggerKeys.HOST, swagger.getHost())
                .add(SwaggerKeys.BASE_PATH, swagger.getBasePath())
                .add(SwaggerKeys.SCHEMES, JsonUtils.createJsonArray(swagger.getSchemes()))
                .add(SwaggerKeys.PATHS, PathsObjectBuilder.createPathsObject(swagger.getPaths()));

        //following fields are optional for a valid swagger specification
        if (swagger.getConsumes().size()>=1){
            swaggerJsonObjectBuilder.add(SwaggerKeys.CONSUMES, JsonUtils.createJsonArray(swagger.getConsumes()));
        }

        if (swagger.getProduces().size()>=1){
            swaggerJsonObjectBuilder.add(SwaggerKeys.PRODUCES, JsonUtils.createJsonArray(swagger.getProduces()));
        }

        if(swagger.getDefinitions() != null && swagger.getDefinitions().getDefinitionsMap().size()>0){
            swaggerJsonObjectBuilder.add(SwaggerKeys.DEFINITIONS, swaggerObjectBuilder.createDefinitionsObject(swagger.getDefinitions().getDefinitionsMap()));
        }

        if(swagger.getParameters() != null  && swagger.getParameters().getParameterDefinitionsMap().size()>0){
            swaggerJsonObjectBuilder.add(SwaggerKeys.PARAMETERS, swaggerObjectBuilder.createParametersDefinitionsObject(swagger.getParameters().getParameterDefinitionsMap()));
        }

        if(swagger.getResponses() != null && swagger.getResponses().getResponseDefinitionsMap().size()>0){
            swaggerJsonObjectBuilder.add(SwaggerKeys.RESPONSES, swaggerObjectBuilder.createResponsesDefinitionsObject(swagger.getResponses().getResponseDefinitionsMap()));
        }

        if(swagger.getSecurityDefinitions() != null && swagger.getSecurityDefinitions().getSecurityDefinitionsMap()!= null && swagger.getSecurityDefinitions().getSecurityDefinitionsMap().size()>0){
            swaggerJsonObjectBuilder.add(SwaggerKeys.SECURITY_DEFINITIONS, swaggerObjectBuilder.createSecurityDefinitionsObject(swagger.getSecurityDefinitions().getSecurityDefinitionsMap()));
        }

        if(swagger.getSecurity().size() > 0){
            swaggerJsonObjectBuilder.add(SwaggerKeys.SECURITY, SecurityRequirementsArrayBuilder.createSecurityRequirementsArray(swagger.getSecurity()));
        }

        if(swagger.getTags().size() > 0){
            swaggerJsonObjectBuilder.add(SwaggerKeys.TAGS, TagsArrayBuilder.createTagsArray(swagger.getTags()));
        }

        if(swagger.getExternalDocs() != null){
            swaggerJsonObjectBuilder.add(SwaggerKeys.EXTERNAL_DOCS, ExternalDocumentationObjectBuilder.createExternalDocsObject(swagger.getExternalDocs()));
        }


        return swaggerJsonObjectBuilder.build();
    }

    public JsonObject createDefinitionsObject(HashMap<String, Schema> definitions){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        List<String> keys = ListUtils.sortSetAlphabetically(definitions.keySet());

        for(String definitionName: keys){
            jsonObjectBuilder.add(definitionName, SchemaObjectBuilder.createSchemaObject(null, definitions.get(definitionName)));
        }

        return jsonObjectBuilder.build();
    }

    public JsonObject createParametersDefinitionsObject(HashMap<String,Parameter> parameterDefinitions){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        List<String> keys = ListUtils.sortSetAlphabetically(parameterDefinitions.keySet());

        for(String parameterName: keys){
            jsonObjectBuilder.add(parameterName, ParametersObjectBuilder.createParameterObject(parameterDefinitions.get(parameterName)));
        }

        return jsonObjectBuilder.build();
    }

    public JsonObject createResponsesDefinitionsObject(HashMap<String,Response> responsesDefinitions){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        List<String> keys = ListUtils.sortSetAlphabetically(responsesDefinitions.keySet());

        for (String responseName: keys){

            jsonObjectBuilder.add(responseName, ResponsesObjectBuilder.createResponseObject(responsesDefinitions.get(responseName)));
        }

        return jsonObjectBuilder.build();
    }

    public JsonObject createSecurityDefinitionsObject(HashMap<String,SecurityScheme> securityDefinitions){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        List<String> keys = ListUtils.sortSetAlphabetically(securityDefinitions.keySet());

        for(String securityDefinitionName: keys){
            jsonObjectBuilder.add(securityDefinitionName, SecuritySchemeObjectBuilder.createSecurityScheme(securityDefinitions.get(securityDefinitionName)));
        }

        return jsonObjectBuilder.build();
    }


}
