package com.ifsworld.rnd.intern.openapi.generator.swagger.model.security;

import java.util.HashMap;

public class Scopes {

    private HashMap<String, String> scopes;

    //getters and setters

    public HashMap<String, String> getScopes() {
        return scopes;
    }

    public void setScopes(HashMap<String, String> scopes) {
        this.scopes = scopes;
    }

    //method to add a Scope to the "scopes" hash map
    public void addScope(String name, String description){
        if(scopes == null){
            scopes = new HashMap<String,String>();
        }
        scopes.put(name, description);
    }

    //this method returns the description of the scope when the name is given from the "scopes" hash map
    public String getScopeDescription(String name){
        if (scopes != null){
            return scopes.get(name);
        }
        return null;
    }

}
