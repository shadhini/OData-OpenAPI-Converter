package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Tag {

    //a required field
    private String name;

    private String description;

    private ExternalDocumentation externalDocs;



    //constructors
    public Tag(String name) {
        this.name = name;
    }


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }
}
