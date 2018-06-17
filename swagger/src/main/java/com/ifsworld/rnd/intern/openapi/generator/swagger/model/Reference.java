package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Reference implements ISchema, IType, IPathItem, IDefinition, IParameter, IResponse{

    public static final String RELATIVE_TO_DEFINITIONS = "#/definitions/";
    public static final String RELATIVE_TO_RESPONSES = "#/responses/";
    public static final String RELATIVE_TO_PARAMETERS = "#/parameters/";

    private String reference;





    //constructor
    public Reference() {
    }

    public Reference(String reference, String relativeTo) {
        this.reference = relativeTo + reference;
    }






    //getters and setters
    public String getReference() {
        return reference;
    }

    //modified
    public void setReference(String reference, String relativeTo) {
        this.reference = relativeTo + reference;
    }

}
