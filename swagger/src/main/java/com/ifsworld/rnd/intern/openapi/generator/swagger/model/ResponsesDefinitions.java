package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

//a singleton class
public class ResponsesDefinitions {

    //Singleton class instance
    private static ResponsesDefinitions instance;

    HashMap<String, Response> responseDefinitionsMap = new HashMap<String, Response>();





    //private constructors
    private ResponsesDefinitions() {
    }







    //getInstance method for the Singleton class

    public static ResponsesDefinitions getInstance(){
        if(instance == null){
            instance = new ResponsesDefinitions();
        }
        return instance;
    }






    //getters and setters
    public HashMap<String, Response> getResponseDefinitionsMap() {
        return responseDefinitionsMap;
    }

    public void setResponseDefinitionsMap(HashMap<String, Response> responseDefinitionsMap) {
        this.responseDefinitionsMap = responseDefinitionsMap;
    }



    //method to add response definitions to the response container
    public void addResponseDefinition(String name, Response response){
        responseDefinitionsMap.put(name, response);
    }
     //method to get response by name
    public Response getResponseDefinition(String name){
        return responseDefinitionsMap.get(name);
    }




    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }
}
