package com.ifsworld.rnd.intern.openapi.generator.common;

import javax.json.*;
import java.io.StringReader;
import java.util.List;

public class JsonUtils {

    //methods to add key, value pair to already existing json object
    public static JsonObject add(JsonObject currentObject, String key, String value){

        String currentObjectString = currentObject.toString();

        String trimmedCurrentObjectString = currentObjectString.substring(1,currentObjectString.length()-1);

        String newJsonObjectString = "{" + trimmedCurrentObjectString + ",\"" + key + "\":\"" + value + "\"}";

        JsonReader jsonReader = Json.createReader(new StringReader(newJsonObjectString));
        JsonObject newJsonObject = jsonReader.readObject();
        jsonReader.close();

        return  newJsonObject;
    }

    public static JsonObject add(JsonObject currentObject, String key, JsonStructure newStructure){

        String currentObjectString = currentObject.toString();

        String trimmedCurrentObjectString = currentObjectString.substring(1,currentObjectString.length()-1);

        String newJsonObjectString = "{" + trimmedCurrentObjectString + ",\"" + key + "\":" + newStructure.toString() + "}";

        JsonReader jsonReader = Json.createReader(new StringReader(newJsonObjectString));
        JsonObject newJsonObject = jsonReader.readObject();
        jsonReader.close();

        return newJsonObject;
    }


    //methods to add values to already existing json array
    public static JsonArray add(JsonArray currentJsonArray, String value){
        String currentString = currentJsonArray.toString();

        String trimmedString = currentString.substring(1,currentString.length()-1);

        String newJsonArrayString = "[" + trimmedString + "," + "\"" + value + "\"]";

        JsonReader jsonReader = Json.createReader(new StringReader(newJsonArrayString));
        JsonArray newJsonArray = jsonReader.readArray();
        jsonReader.close();

        return  newJsonArray;
    }

    public static JsonArray add(JsonArray currentJsonArray, JsonStructure jsonStructure){
        String currentString = currentJsonArray.toString();

        String trimmedString = currentString.substring(1,currentString.length()-1);

        String newJsonArrayString = "[" + trimmedString + "," + jsonStructure.toString() + "]";

        JsonReader jsonReader = Json.createReader(new StringReader(newJsonArrayString));
        JsonArray newJsonArray = jsonReader.readArray();
        jsonReader.close();

        return  newJsonArray;
    }


    //method to create a JsonArray from a String list
    public static JsonArray createJsonArray(List<String> list){

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        if (list != null && list.size()>=1) {
            for (String item : list) {
                jsonArrayBuilder.add(item);
            }
            return jsonArrayBuilder.build();
        }else{
            return null;
        }
    }



    //methods to stringify json structures
//    public static String stringify(JsonStructure jsonStructure){
//        String jsonString = jsonStructure.toString().replace("\"","\\\"");
//        return jsonString;
//    }
//
//    public static String stringify(String string){
//        return string.replace("\"","\\\"");
//    }

}
