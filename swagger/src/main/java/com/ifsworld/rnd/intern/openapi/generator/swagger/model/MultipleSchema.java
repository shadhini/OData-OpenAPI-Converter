package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.ArrayList;
import java.util.List;

public class MultipleSchema extends Schema{

    private List<ISchema> allOf;

    //getters and setters
    public List<ISchema> getAllOf() {
        return allOf;
    }

    public void setAllOf(List<ISchema> allOf) {
        this.allOf = allOf;
    }

    //methods to add elements to lists
    public void addToAllOf(ISchema typeOrReference){
        if(allOf == null){
            allOf = new ArrayList<ISchema>();
        }
        allOf.add(typeOrReference);
    }
}
