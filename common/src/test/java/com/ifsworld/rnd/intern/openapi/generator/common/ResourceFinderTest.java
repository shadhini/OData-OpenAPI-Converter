package com.ifsworld.rnd.intern.openapi.generator.common;

public class ResourceFinderTest {

    public static void main(String[] args) {

        //--testing public static String findResource(String fileName, Boolean RelativeToRoot) method
        String fileName1 = "test/test.json";
        String path1 = ResourceLocator.findResource(fileName1, false);
        System.out.println("Absolute path to test.json file @src/main/resources/test: " + path1);

        String fileName2 = "swagger/swagger.json";
        String path2 = ResourceLocator.findResource(fileName2,true);
        System.out.println("Absolute path to test.json at the test folder @ root directory: " + path2);


        //--testing  public static String findResource(Object currentClass, String fileName) method
        String path3 = ResourceLocator.findResource(ResourceLocator.class,fileName1);
        System.out.println("(method 2)Absolute path to test.json file @src/main/resources/test: " + path3);
    }
}
