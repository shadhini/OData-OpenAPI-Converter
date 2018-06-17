package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.ListUtils;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.IPathItem;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.PathItem;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Paths;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Reference;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.http_methods.Operation;
import com.ifsworld.rnd.intern.openapi.generator.common.JsonUtils;
import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.HashMap;
import java.util.List;

public class PathsObjectBuilder {

    public JsonObject createEmptyPathsObject(){
        return Json.createObjectBuilder().build();
    }



    public static JsonObject createPathsObject(Paths paths){

        PathsObjectBuilder pathsObjectBuilder = new PathsObjectBuilder();

        JsonObjectBuilder pathsJsonObjectBuilder = Json.createObjectBuilder();


        if (paths.getPathsMap().size() > 0){

            HashMap<String, IPathItem> pathItemHashMap = paths.getPathsMap();

            List<String> keys = ListUtils.sortSetAlphabetically(paths.getPathsMap().keySet());

            for (String path: keys) {
                pathsJsonObjectBuilder.add("/"+path, pathsObjectBuilder.createPathItemObject(pathItemHashMap.get(path)));
            }

            return pathsJsonObjectBuilder.build();

        }else{

            return pathsObjectBuilder.createEmptyPathsObject();

        }
    }

    public JsonObject createOperationObject(Operation operation){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();


        if(operation.getTags().size() > 0){
            jsonObjectBuilder.add(SwaggerKeys.TAGS, JsonUtils.createJsonArray(operation.getTags()));
        }

        if(operation.getSummary() != null){
            jsonObjectBuilder.add(SwaggerKeys.SUMMARY, operation.getSummary());
        }

        if(operation.getDescription() != null){
            jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, operation.getDescription());
        }

        if(operation.getOperationId() != null){
            jsonObjectBuilder.add(SwaggerKeys.OPERATION_ID, operation.getOperationId());
        }

        if(operation.getConsumes() != null && operation.getConsumes().size() > 0 ){
            jsonObjectBuilder.add(SwaggerKeys.CONSUMES, JsonUtils.createJsonArray(operation.getConsumes()));
        }

        if(operation.getProduces() != null && operation.getProduces().size() > 0 ){
            jsonObjectBuilder.add(SwaggerKeys.PRODUCES, JsonUtils.createJsonArray(operation.getProduces()));
        }

        if(operation.getParameters().size() > 0){
            jsonObjectBuilder.add(SwaggerKeys.PARAMETERS, ParametersObjectBuilder.createParametersObject(operation.getParameters()));
        }


        jsonObjectBuilder.add(SwaggerKeys.RESPONSES, ResponsesObjectBuilder.createResponsesObject(operation.getResponses()));

        if(operation.getSchemes() != null && operation.getSchemes().size() > 0 ){
            jsonObjectBuilder.add(SwaggerKeys.SCHEMES, JsonUtils.createJsonArray(operation.getSchemes()));
        }

        if(operation.getIsDeprecated() != null ){
            jsonObjectBuilder.add(SwaggerKeys.DEPRECATED, operation.getIsDeprecated());
        }

        if(operation.getSecurity() != null && operation.getSecurity().size() > 0 ){
            jsonObjectBuilder.add(SwaggerKeys.SECURITY, SecurityRequirementsArrayBuilder.createSecurityRequirementsArray(operation.getSecurity()));
        }


        return jsonObjectBuilder.build();
    }

    public JsonObject createPathItemObject(IPathItem pathItem){

        PathsObjectBuilder pathsObjectBuilder = new PathsObjectBuilder();

        JsonObjectBuilder pathItemObjectBuilder = Json.createObjectBuilder();

        if(pathItem instanceof Reference){
            Reference reference = (Reference) pathItem;
            pathItemObjectBuilder.add(SwaggerKeys.REFERENCE, reference.getReference() );
        }else if (pathItem instanceof PathItem){
            PathItem concretePathItem = (PathItem) pathItem;

            if (concretePathItem.getGet() != null) {
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_GET, pathsObjectBuilder.createOperationObject(concretePathItem.getGet()));
            }
            if(concretePathItem.getPost() != null){
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_POST, pathsObjectBuilder.createOperationObject(concretePathItem.getPost()));
            }
            if(concretePathItem.getPut() != null){
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_PUT, pathsObjectBuilder.createOperationObject(concretePathItem.getPut()));
            }
            if(concretePathItem.getPatch() != null){
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_PATCH, pathsObjectBuilder.createOperationObject(concretePathItem.getPatch()));
            }
            if(concretePathItem.getDelete() != null){
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_DELETE, pathsObjectBuilder.createOperationObject(concretePathItem.getDelete()));
            }
            if(concretePathItem.getHead() != null){
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_HEAD, pathsObjectBuilder.createOperationObject(concretePathItem.getHead()));
            }
            if(concretePathItem.getOptions() != null){
                pathItemObjectBuilder.add(SwaggerKeys.HTTP_OPTIONS, pathsObjectBuilder.createOperationObject(concretePathItem.getOptions()));
            }

            if(concretePathItem.getParameters() != null && concretePathItem.getParameters().size()>0){
                pathItemObjectBuilder.add(SwaggerKeys.PARAMETERS, ParametersObjectBuilder.createParametersObject(concretePathItem.getParameters()));
            }
        }



        return pathItemObjectBuilder.build();
    }



}
