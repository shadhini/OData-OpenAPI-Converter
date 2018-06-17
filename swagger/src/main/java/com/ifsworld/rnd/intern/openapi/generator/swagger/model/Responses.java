package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

public class Responses {

    private HashMap<String, IResponse> responsesMap = new HashMap<String,IResponse>();






   //constructors
    public Responses() {
        responsesMap.put("default",new Response());
    }


    //getters and setters
    public HashMap<String, IResponse> getResponsesMap() {
        return responsesMap;
    }

    public void setResponsesMap(HashMap<String, IResponse> responsesMap) {
        this.responsesMap = responsesMap;
    }



    //methods to add elements to lists
    public void addResponse(String httpStatusCode, IResponse response){
        responsesMap.put(httpStatusCode, response);
    }

    //this method returns the corresponding Response when the http status code is provided, from the "responsesMap" hash map
    public IResponse getResponse(String httpStatusCode){
        return responsesMap.get(httpStatusCode);
    }
}
