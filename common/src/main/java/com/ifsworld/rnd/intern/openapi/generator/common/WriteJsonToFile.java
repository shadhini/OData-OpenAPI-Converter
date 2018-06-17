package com.ifsworld.rnd.intern.openapi.generator.common;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteJsonToFile {

    //this function writes given json object to given path
    public static void write(JsonObject jsonObject, String absolutePath){

        System.out.println("Resource path: " +absolutePath);

        File file = new File(absolutePath);


        System.out.println("A swagger.json file already exist: " + file.exists());
        if(file.delete()){
            System.out.println("File has been successfully deleted.");
        }



        try {
            System.out.println("Json Object before writing into the file : ");
            System.out.println(jsonObject.toString());
            JsonWriter jsonWriter = Json.createWriter(
                    Files.newBufferedWriter(Paths.get(absolutePath),StandardOpenOption.CREATE_NEW));
            jsonWriter.writeObject(jsonObject);
            System.out.println("Swagger Specification has been successfully written to swagger/swagger.json file");
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
