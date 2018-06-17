package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import java.util.ArrayList;
import java.util.List;

public class OBJECT {

    private List<Property> properties = new ArrayList<Property>();

    private AdditionalProperty additionalProperty;



    //getters and setters
    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public AdditionalProperty getAdditionalProperty() {
        return additionalProperty;
    }

    public void setAdditionalProperty(AdditionalProperty additionalProperty) {
        this.additionalProperty = additionalProperty;
    }



    //methods to add elements to lists
    public void addProperty(Property property){
        properties.add(property);
    }
}
