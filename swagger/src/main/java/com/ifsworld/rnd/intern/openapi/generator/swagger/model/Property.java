package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Property{

    private String propertyTitle;

    private ISchema schemaOrReference;

    private Boolean readOnly;






    //constructors
    public Property(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public Property(String propertyTitle, ISchema schemaOrReference) {
        this.propertyTitle = propertyTitle;
        this.schemaOrReference = schemaOrReference;
    }

    //getters and setters
    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public ISchema getSchemaOrReference() {
        return schemaOrReference;
    }

    //modified, so that property can contain MultipleSchema
    public void setSchemaOrReference(ISchema schemaOrReference) {
        this.schemaOrReference = schemaOrReference;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }
}
