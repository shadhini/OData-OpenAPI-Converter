package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Header {

    private String description;

    private IType type;


    //getters and setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IType getType() {
        return type;
    }

    public void setType(IType type) {
        this.type = type;
    }

}
