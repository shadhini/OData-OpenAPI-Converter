package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.ArrayList;
import java.util.List;

public class Type_Object extends Type{

    private OBJECT value;

    //--------------validation keywords for objects---------------------------------------------

    //value of this field must be greater than or equal to 0
    private Number maxProperties;

    //value of this field must be greater than or equal to 0 and the default value has been set to 0
    private Number minProperties = 0;

    private List<String> required;





    //getters and setters
    public OBJECT getValue() {
        return value;
    }

    public void setValue(OBJECT value) {
        this.value = value;
    }

    public Number getMaxProperties() {
        return maxProperties;
    }

    public void setMaxProperties(Number maxProperties) {
        if(maxProperties.intValue() >= 0) {
            this.maxProperties = maxProperties;
        }
    }

    public Number getMinProperties() {
        return minProperties;
    }

    public void setMinProperties(Number minProperties) {
        if(minProperties.intValue() >= 0) {
            this.minProperties = minProperties;
        }
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }







    //methods to add elements to lists
    public void addRequiredElement(String requiredElement){
        if(required == null){
            required = new ArrayList<String>();
        }

        required.add(requiredElement);
    }
}
