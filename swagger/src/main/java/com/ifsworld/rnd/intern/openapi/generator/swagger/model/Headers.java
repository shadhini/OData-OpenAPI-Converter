package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

public class Headers {

    private HashMap<String, Header> headersMap;


    //getters and setters
    public HashMap<String, Header> getHeadersMap() {
        return headersMap;
    }

    public void setHeadersMap(HashMap<String, Header> headersMap) {
        this.headersMap = headersMap;
    }


    //method to add a header to the "headersMap" hash map
    public void addHeader(String name, Header header){
        if (headersMap == null){
            headersMap = new HashMap<String, Header>();
        }
        headersMap.put(name, header);
    }

    //method to get the header for a given name from the "headersMap" hash map
    public Header getHeader(String name){
        if(headersMap != null) {
            return headersMap.get(name);
        }
        return  null;
    }
}
