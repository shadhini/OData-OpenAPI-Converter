package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.HashMap;

//a singleton class
public class Paths {

    //Singleton class instance
    private static Paths instance;

    private HashMap<String,IPathItem> pathsMap = new HashMap<String,IPathItem>();






    //constructors
    private Paths(){

    }





    //getInstance method for the Singleton class

    public static Paths getInstance(){
        if(instance == null){
            instance = new Paths();
        }
        return instance;
    }







    //getters and setters

    public HashMap<String, IPathItem> getPathsMap() {
        return pathsMap;
    }

    public void setPathsMap(HashMap<String, IPathItem> pathsMap) {
        this.pathsMap = pathsMap;
    }



    //add elements to "pathsMap" hash map
    public void addPath(String path, IPathItem pathItem){
        pathsMap.put(path,pathItem);
    }

    //returns the corresponding PathItem from pathsMap hash map when the path is given
    public IPathItem getPath(String path){
        return pathsMap.get(path);
    }


    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }

}
