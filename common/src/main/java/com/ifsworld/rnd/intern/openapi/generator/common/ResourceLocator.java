package com.ifsworld.rnd.intern.openapi.generator.common;

import java.net.URL;
import java.nio.file.Paths;

public class ResourceLocator {

    //if RelativeToRoot is true, when the relative path from the root is given, returns the absolute path to the resource
    //if RelativeToRoot is false,
    //      when the relative path from src/main/resources is given, returns the absolute path to the resource
    public static String findResource(String fileName, Boolean RelativeToRoot){

        if (RelativeToRoot) {

            return String.valueOf(Paths.get("./" + fileName).toAbsolutePath().normalize());

        }else {

            URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);

            ResourceLocator resourceLocator = new ResourceLocator();

            return resourceLocator.extractResourcePath(url);
        }
    }

    // When the relative path from src/main/resources is given, returns the absolute path to the resource,
    // if it is in the same package as the class provided when calling the function
    public static String findResource(Object currentClass, String fileName){

        URL url = currentClass.getClass().getResource("/"+fileName);

        ResourceLocator resourceLocator = new ResourceLocator();

        return resourceLocator.extractResourcePath(url);
    }

    public static String findResource(String relativePathFromWebappRoot){

        return String.valueOf(Paths.get("../" + relativePathFromWebappRoot).toAbsolutePath().normalize());
    }

    public String extractResourcePath(URL url){

        String resourcePath1;
        String resourcePath2;
        try {
            resourcePath1 = url.toString().split("file:/")[1];
            return  resourcePath1;
        }catch (NullPointerException e){
            try {
                resourcePath2 = url.toString().split("file:")[1];
                return resourcePath2;
            }catch (NullPointerException e2){
            }
        }
        return null;
    }


}
