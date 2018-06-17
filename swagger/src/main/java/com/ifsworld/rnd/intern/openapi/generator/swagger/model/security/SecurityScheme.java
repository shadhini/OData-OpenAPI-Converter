package com.ifsworld.rnd.intern.openapi.generator.swagger.model.security;

public abstract class SecurityScheme {

    //security related swagger key words
    public static final String BASIC = "basic";
    public static final String API_KEY = "apiKey";
    public static final String OAUTH2 = "oauth2";

    //required field
    private String type;

    private String description;

    //getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
