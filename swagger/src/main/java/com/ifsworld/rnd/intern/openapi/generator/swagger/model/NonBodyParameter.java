package com.ifsworld.rnd.intern.openapi.generator.swagger.model;


public class NonBodyParameter extends Parameter{

    private Type type;

    private Boolean allowEmptyValue;








    @Override
    public void setIn(String in) {
        if(in != Parameter.IN_BODY) {
            super.setIn(in);
        }
    }



    //getters and setters

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getAllowEmptyValue() {
        return allowEmptyValue;
    }

    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        this.allowEmptyValue = allowEmptyValue;
    }

}
