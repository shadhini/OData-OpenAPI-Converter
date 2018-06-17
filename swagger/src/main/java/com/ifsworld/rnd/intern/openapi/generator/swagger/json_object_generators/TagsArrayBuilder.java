package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Tag;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.util.List;

public class TagsArrayBuilder {

    public static JsonArray createTagsArray(List<Tag> tags){

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        for (Tag tag : tags){
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

            jsonObjectBuilder.add(SwaggerKeys.NAME, tag.getName());

            if(tag.getDescription() != null){
                jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, tag.getDescription());
            }

            if(tag.getExternalDocs() != null){
                jsonObjectBuilder.add(SwaggerKeys.EXTERNAL_DOCS, ExternalDocumentationObjectBuilder.createExternalDocsObject(tag.getExternalDocs()));
            }
            jsonArrayBuilder.add(jsonObjectBuilder.build());
        }
        return jsonArrayBuilder.build();
    }
}
