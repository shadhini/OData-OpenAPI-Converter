package com.ifsworld.rnd.intern.openapi.generator.swagger.model.security;

public class ApiKey extends SecurityScheme {

    public static final String IN_QUERY = "query";
    public static final String IN_HEADER = "header";

    //required field
    private String name;

    //required field
    private String in;


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }
}
