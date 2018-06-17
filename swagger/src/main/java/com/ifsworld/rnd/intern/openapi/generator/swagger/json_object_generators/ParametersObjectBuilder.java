package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;

import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;

import javax.json.*;
import java.util.List;

public class ParametersObjectBuilder {

    //method to create "parameters" swagger object (a json array) for a given list of parameters/references
    public static JsonArray createParametersObject(List<IParameter> parameters){

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        if(parameters != null && parameters.size() > 0){
            for (IParameter iParameter : parameters){
                jsonArrayBuilder.add(createParameterObject(iParameter));
            }
        }

        return jsonArrayBuilder.build();
    }

    public static JsonObject createParameterObject(IParameter iParameter){

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        if(iParameter instanceof Parameter){

            Parameter parameter = (Parameter) iParameter;

            if(parameter.getName() != null && parameter.getIn() != null && parameter.getRequired() !=  null) {
                jsonObjectBuilder.add(SwaggerKeys.NAME, parameter.getName())
                        .add(SwaggerKeys.IN, parameter.getIn())
                        .add(SwaggerKeys.REQUIRED, parameter.getRequired());


                if (parameter.getDescription() != null) {
                    jsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, parameter.getDescription());
                }


                if (parameter instanceof NonBodyParameter) {
                    NonBodyParameter nonBodyParameter = (NonBodyParameter) parameter;

                    if (nonBodyParameter.getAllowEmptyValue() != null) {
                        jsonObjectBuilder.add(SwaggerKeys.ALLOW_EMPTY_VALUE, nonBodyParameter.getAllowEmptyValue());
                    }

                    if (nonBodyParameter.getType() != null) {
                        return SchemaObjectBuilder.createTypeObject(jsonObjectBuilder, nonBodyParameter.getType());
                    }


                } else if (parameter instanceof BodyParameter) {
                    BodyParameter bodyParameter = (BodyParameter) parameter;
                    jsonObjectBuilder.add(SwaggerKeys.SCHEMA, SchemaObjectBuilder.createSchemaObject(null, bodyParameter.getSchema()));
                }
            }

        }else if (iParameter instanceof Reference){

            Reference reference = (Reference) iParameter;
            jsonObjectBuilder.add(SwaggerKeys.REFERENCE, reference.getReference() );

        }

        return jsonObjectBuilder.build();
    }
}
