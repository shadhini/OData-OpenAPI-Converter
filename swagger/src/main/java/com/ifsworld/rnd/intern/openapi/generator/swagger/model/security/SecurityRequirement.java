package com.ifsworld.rnd.intern.openapi.generator.swagger.model.security;

import java.util.HashMap;
import java.util.List;

public class SecurityRequirement {

    private HashMap<String, List<String>> securityRequirementsMap;


    //getters and setters

    public HashMap<String, List<String>> getSecurityRequirementsMap() {
        return securityRequirementsMap;
    }

    public void setSecurityRequirementsMap(HashMap<String, List<String>> securityRequirementsMap) {
        this.securityRequirementsMap = securityRequirementsMap;
    }

    //method to add a Scope to the "scopes" hash map
    public void addSecurityRequirement(String name, List<String> securityDefinitions){
        if(securityRequirementsMap == null){
            securityRequirementsMap = new HashMap<String, List<String>>();
        }
        securityRequirementsMap.put(name, securityDefinitions);
    }

    //this method returns the description of the scope when the name is given from the "scopes" hash map
    public List<String> getSecurityRequirement(String name){
        if (securityRequirementsMap != null){
            return securityRequirementsMap.get(name);
        }
        return null;
    }
}
