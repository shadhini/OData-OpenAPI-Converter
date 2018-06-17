package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.ExternalDocumentation;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class ExternalDocumentationObjectBuilder {

    public static JsonObject createExternalDocsObject(ExternalDocumentation externalDocumentation){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        if (externalDocumentation.getDescription() != null){
            jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, externalDocumentation.getDescription());
        }

        if(externalDocumentation.getUrl() != null){
            jsonObjectBuilder.add(SwaggerKeys.URL, externalDocumentation.getUrl());
        }

        return jsonObjectBuilder.build();
    }
}
