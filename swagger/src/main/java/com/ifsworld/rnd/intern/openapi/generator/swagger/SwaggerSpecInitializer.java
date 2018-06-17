package com.ifsworld.rnd.intern.openapi.generator.swagger;


import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;


public class SwaggerSpecInitializer {

    public static void initializeSwaggerSpec(){

        Swagger.clear();
        Definitions.clear();
        Info.clear();
        ParametersDefinitions.clear();
        Paths.clear();
        ResponsesDefinitions.clear();
        SecurityDefinitions.clear();

        Swagger.getInstance();

        SwaggerSpecInitializer swaggerSpecInitializer = new SwaggerSpecInitializer();
        swaggerSpecInitializer.addCommonResponses();

    }

    public void addCommonResponses(){

        ResponsesDefinitions responsesDefinitions = ResponsesDefinitions.getInstance();
        responsesDefinitions.addResponseDefinition("undocumented",
                new Response("An Error occurred! This error has not been documented in the specification."));


    }


}
