package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;


public class X_Patterned {

    private HashMap<String, IX_Patterned> x_patterned_fields;

    //getters and setters

    public HashMap<String, IX_Patterned> getX_patterned_fields() {
        return x_patterned_fields;
    }

    public void setX_patterned_fields(HashMap<String, IX_Patterned> x_patterned_fields) {
        this.x_patterned_fields = x_patterned_fields;
    }

    //method to add a new X_Patterned field to the map
    public void addX_Patterned_Field(String name, IX_Patterned x_patterned){
        x_patterned_fields.put(name,x_patterned);
    }

    //this method returns a particular x-patterned field when the name of the x-patterned field is given
    public IX_Patterned getX_Patterned_Field(String name){
        if(x_patterned_fields != null){
            return x_patterned_fields.get(name);
        }
        return null;
    }
}
