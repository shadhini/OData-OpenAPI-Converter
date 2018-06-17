package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import com.ifsworld.rnd.intern.openapi.generator.swagger.model.security.SecurityScheme;

import java.util.HashMap;

//a singleton class
public class SecurityDefinitions {

    //singleton class instance
    private static SecurityDefinitions instance;


    private HashMap<String, SecurityScheme> securityDefinitionsMap;



    //private constructor
    private SecurityDefinitions() {
    }



    //getInstance method for singleton class
    public static SecurityDefinitions getInstance() {
        return instance;
    }





    //getters and setters

    public HashMap<String, SecurityScheme> getSecurityDefinitionsMap() {
        return securityDefinitionsMap;
    }

    public void setSecurityDefinitionsMap(HashMap<String, SecurityScheme> securityDefinitionsMap) {
        this.securityDefinitionsMap = securityDefinitionsMap;
    }

    //method to add Security Schemes to "securityDefinitionsMap" hash map
    public void addSecurityScheme(String name, SecurityScheme securityScheme){
        if(securityDefinitionsMap == null){
            securityDefinitionsMap = new HashMap<String, SecurityScheme>();
        }
        securityDefinitionsMap.put(name,securityScheme);
    }

    //this method returns the Security Scheme for a given name from the "securityDefinitionsMap" hash map
    public SecurityScheme getSecurityScheme(String name){
        if(securityDefinitionsMap != null) {
            return securityDefinitionsMap.get(name);
        }
        return null;
    }

    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }
}
