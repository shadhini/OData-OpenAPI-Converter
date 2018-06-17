package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

public class Example {

    private HashMap<String, Object> examples;

    //getters and setters

    public HashMap<String, Object> getExamples() {
        return examples;
    }

    public void setExamples(HashMap<String, Object> examples) {
        this.examples = examples;
    }

    //method to add an example to the "examples" hash map
    public void addExample(String mimeType, Object object){
        if(examples == null){
            examples = new HashMap<String, Object>();
        }
        examples.put(mimeType, object);
    }

    //method to get an example for a given mimeType from the hash map
    public Object getExample(String mimeType){
        if(examples != null) {
            return examples.get(mimeType);
        }
        return null;
    }
}
