package com.ifsworld.rnd.intern.openapi.generator.swagger.model;


public class Type_Array extends  Type {

    private ARRAY value;

    //default value of this field is set to "csv" collection format
    private String collectionFormat;

    //-------------validation keywords for arrays-----------------------------

    //value of this field must be greater than or equal to 0
    private Number maxItems;

    //value of this field must be greater than or equal to 0 and the default value has been set to 0
    private Number minItems = 0;


    //the default value of this field has been set to false
    private Boolean uniqueItems = false;

    //getters and setters
    public ARRAY getValue() {
        return value;
    }

    public void setValue(ARRAY value) {
        this.value = value;
    }

    public Number getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(Number maxItems) {
        if(maxItems.intValue() >= 0) {
            this.maxItems = maxItems;
        }
    }

    public Number getMinItems() {
        return minItems;
    }

    public void setMinItems(Number minItems) {
        if(minItems.intValue() >= 0 ) {
            this.minItems = minItems;
        }
    }

    public Boolean getUniqueItems() {
        return uniqueItems;
    }

    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    public String getCollectionFormat() {
        return collectionFormat;
    }

    public void setCollectionFormat(String collectionFormat) {
        this.collectionFormat = collectionFormat;
    }
}
