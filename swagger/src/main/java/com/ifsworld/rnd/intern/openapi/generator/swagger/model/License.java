package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class License {

    //a required field
    private String name = "anonymous";

    private String url;

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
