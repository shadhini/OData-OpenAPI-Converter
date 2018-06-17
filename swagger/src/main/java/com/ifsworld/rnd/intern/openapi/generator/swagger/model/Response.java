package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Response implements IResponse{

    private String description = "Default description for all HTTP codes that are not handled individually by the specification.";

    private ISchema schema;

    private Headers headers;

    private Example example;


    //constructors
    public Response() {
    }

    public Response(String description) {
        this.description = description;
    }

    public Response(String description, ISchema schema) {
        this.description = description;
        this.schema = schema;
    }

    //getters and setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ISchema getSchema() {
        return schema;
    }

    public void setSchema(ISchema schema) {
        this.schema = schema;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }



}
