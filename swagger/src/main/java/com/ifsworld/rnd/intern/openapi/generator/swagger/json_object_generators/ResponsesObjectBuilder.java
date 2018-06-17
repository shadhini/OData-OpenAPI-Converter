package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.ListUtils;
import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ResponsesObjectBuilder {


    public static JsonObject createResponsesObject(Responses responses){

        HashMap<String, IResponse> responsesMap = responses.getResponsesMap();

        ResponsesObjectBuilder responsesObjectBuilder = new ResponsesObjectBuilder();

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        Set<String> keys;

        if(responsesMap != null && responsesMap.size()>0){
            keys = responsesMap.keySet();
            for(String httpStatusCode: keys){
                jsonObjectBuilder.add(httpStatusCode, responsesObjectBuilder.createResponseObject(responsesMap.get(httpStatusCode)));
            }
        }
        return jsonObjectBuilder.build();
    }

    public static JsonObject createResponseObject(IResponse response){

        ResponsesObjectBuilder responsesObjectBuilder = new ResponsesObjectBuilder();

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        if(response instanceof Reference){

            Reference reference = (Reference) response;
            jsonObjectBuilder.add(SwaggerKeys.REFERENCE, reference.getReference() );

        }else if(response instanceof Response) {

            Response responseObject = (Response) response;
            jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, responseObject.getDescription());

            if (responseObject.getSchema() != null) {
                jsonObjectBuilder.add(SwaggerKeys.SCHEMA, SchemaObjectBuilder.createSchemaObject(null, responseObject.getSchema()));
            }

            if(responseObject.getHeaders() != null && responseObject.getHeaders().getHeadersMap() != null && responseObject.getHeaders().getHeadersMap().size() > 0){
                jsonObjectBuilder.add(SwaggerKeys.HEADERS, responsesObjectBuilder.createHeadersObject(responseObject.getHeaders().getHeadersMap()) );
            }

            if(responseObject.getExample() != null){
                jsonObjectBuilder.add(SwaggerKeys.EXAMPLE, ExampleObjectBuilder.createExampleObject());
            }

        }

        return jsonObjectBuilder.build();

    }

    public JsonObject createHeadersObject(HashMap<String, Header> headersMap){

        ResponsesObjectBuilder responsesObjectBuilder = new ResponsesObjectBuilder();

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        List<String> keys = ListUtils.sortSetAlphabetically(headersMap.keySet());

        for(String headerName: keys){
            jsonObjectBuilder.add(headerName, responsesObjectBuilder.createHeaderObject(headersMap.get(headerName)));
        }

        return jsonObjectBuilder.build();
    }

    public JsonObject createHeaderObject(Header header){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        if(header.getDescription() != null) {
            jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, header.getDescription());
        }

        if(header.getType() != null){
            return SchemaObjectBuilder.createTypeObject(jsonObjectBuilder,header.getType());
        }

        return jsonObjectBuilder.build();
    }
}
