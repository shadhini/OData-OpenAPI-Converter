package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

//a singleton class
public class Definitions {

    //Singleton class instance
    private static Definitions instance;

    private HashMap<String, Schema> definitionsMap = new HashMap<String, Schema>();







    //private constructor
    private Definitions() {
    }





    //getInstance method for the Singleton class

    public static Definitions getInstance(){
        if(instance == null){
            instance = new Definitions();
        }
        return instance;
    }



    //getters and setters


    public HashMap<String, Schema> getDefinitionsMap() {
        return definitionsMap;
    }

    public void setDefinitionsMap(HashMap<String, Schema> definitionsMap) {
        this.definitionsMap = definitionsMap;
    }

    //methods to add elements to arrays
    public void addDefinition(String name, Schema definition){
        definitionsMap.put(name,definition);
    }

    //this method returns definition for a given name from the "definitionsMap" hash map
    public Schema getDefinition(String name){
        return definitionsMap.get(name);
    }



    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }
}
