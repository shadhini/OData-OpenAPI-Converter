package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class BodyParameter extends Parameter {

    private ISchema schema;




    //constructors
    public BodyParameter() {
        super.setIn(Parameter.IN_BODY);
    }


    //getters and setters
    public ISchema getSchema() {
        return schema;
    }

    public void setSchema(ISchema schema) {
        this.schema = schema;
    }
}
