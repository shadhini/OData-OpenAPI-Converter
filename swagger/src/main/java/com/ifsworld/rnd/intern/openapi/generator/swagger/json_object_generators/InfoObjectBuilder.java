package com.ifsworld.rnd.intern.openapi.generator.swagger.json_object_generators;


import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Contact;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Info;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.License;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class InfoObjectBuilder {

    public static JsonObject createInfoObject(Info info){

        InfoObjectBuilder infoObjectBuilder = new InfoObjectBuilder();

        JsonObjectBuilder infoJsonObjectBuilder = Json.createObjectBuilder();

        infoJsonObjectBuilder.add(SwaggerKeys.TITLE, info.getTitle())
                .add(SwaggerKeys.VERSION, info.getVersion());

        if(info.getDescription() != null){
            infoJsonObjectBuilder.add(SwaggerKeys.DESCRIPTION, info.getDescription());
        }

        if(info.getTermsOfService() != null){
            infoJsonObjectBuilder.add(SwaggerKeys.TERMS_OF_SERVICE, info.getTermsOfService());
        }

        if(info.getContact() != null){
            infoJsonObjectBuilder.add(SwaggerKeys.CONTACT, infoObjectBuilder.createContactObject(info.getContact()));
        }

        if(info.getLicense() != null){
            infoJsonObjectBuilder.add(SwaggerKeys.LICENSE, infoObjectBuilder.createLicenseObject(info.getLicense()));
        }

        return infoJsonObjectBuilder.build();
    }


    public JsonObject createContactObject(Contact contact){

        JsonObjectBuilder contactJsonObjectBuilder = Json.createObjectBuilder();

        if(contact.getName() != null){
            contactJsonObjectBuilder.add(SwaggerKeys.NAME, contact.getName());
        }

        if(contact.getUrl() != null){
            contactJsonObjectBuilder.add(SwaggerKeys.URL, contact.getUrl());
        }

        if(contact.getEmail() != null){
            contactJsonObjectBuilder.add(SwaggerKeys.EMAIL, contact.getEmail());
        }

        return contactJsonObjectBuilder.build();
    }

    public JsonObject createLicenseObject(License license){

        JsonObjectBuilder licenseJsonObjectBuilder = Json.createObjectBuilder();


        licenseJsonObjectBuilder.add(SwaggerKeys.NAME, license.getName());


        if(license.getUrl() != null){
            licenseJsonObjectBuilder.add(SwaggerKeys.URL, license.getUrl());
        }


        return licenseJsonObjectBuilder.build();
    }

}
