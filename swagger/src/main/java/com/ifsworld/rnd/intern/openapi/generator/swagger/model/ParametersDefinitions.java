package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

//a singleton class
public class ParametersDefinitions {


    //singleton class instance
    private static ParametersDefinitions instance;

    private HashMap<String, Parameter> parameterDefinitionsMap = new HashMap<String, Parameter>();


    //private constructor
    private ParametersDefinitions() {
    }



    //getInstance method for singleton class
    public static ParametersDefinitions getInstance() {
        if(instance == null){
            instance = new ParametersDefinitions();
        }
        return instance;
    }


    //getters and setters
    public HashMap<String, Parameter> getParameterDefinitionsMap() {
        return parameterDefinitionsMap;
    }

    public void setParameterDefinitionsMap(HashMap<String, Parameter> parameterDefinitionsMap) {
        this.parameterDefinitionsMap = parameterDefinitionsMap;
    }


    //method to add elements to "parameterDefinitionsMap" map
    public void addParameterDefinition(String name, Parameter parameter){
        parameterDefinitionsMap.put(name,parameter);
    }

    //method to get Parameter definition by name
    public Parameter getParameterDefinition(String name){
        return parameterDefinitionsMap.get(name);
    }

    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }
}
