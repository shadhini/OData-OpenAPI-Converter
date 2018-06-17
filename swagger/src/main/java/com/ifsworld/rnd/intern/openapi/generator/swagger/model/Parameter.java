package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public abstract class Parameter implements IParameter {

    public static final String IN_QUERY = "query";
    public static final String IN_HEADER = "header";
    public static final String IN_PATH= "path";
    public static final String IN_FORM_DATA = "formData";
    public static final String IN_BODY = "body";

    //a required field
    private String name;

    //this is a required field; possible values are "query", "header", "path", "formData" or "body"
    private String in;

    //a required field
    private String description;

    //a required field and it's default value has been set to "false"
    private Boolean required = false;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

}
