package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.ListUtils;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.security.SecurityRequirement;
import com.ifsworld.rnd.intern.openapi.generator.common.JsonUtils;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.util.HashMap;
import java.util.List;

public class SecurityRequirementsArrayBuilder {

    public static JsonArray createSecurityRequirementsArray(List<SecurityRequirement> securityRequirements){

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        for(SecurityRequirement securityRequirement: securityRequirements) {


            if(securityRequirement.getSecurityRequirementsMap() != null){
                HashMap<String, List<String>> securityRequirementsMap = securityRequirement.getSecurityRequirementsMap();

                List<String> keys = ListUtils.sortSetAlphabetically(securityRequirementsMap.keySet());

                for(String name: keys){
                    JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                    jsonObjectBuilder.add(name, JsonUtils.createJsonArray(securityRequirementsMap.get(name)));
                    jsonArrayBuilder.add(jsonObjectBuilder.build());
                }

            }
        }

        return jsonArrayBuilder.build();
    }
}
