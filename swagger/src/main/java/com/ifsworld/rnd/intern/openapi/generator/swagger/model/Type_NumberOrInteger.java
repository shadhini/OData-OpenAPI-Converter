package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Type_NumberOrInteger extends  Type {

    private Number value;

    //-------------validation keywords for numeric instances(number and integer)-----------------------

    //must be strictly greater than 0
    private Number multipleOf;

    private Number maximum;

    //present only if maximum is present and default value is set to false
    private Boolean exclusiveMaximum = false;

    private Number minimum;

    //present only if minimum is present and the default value is set to false
    private Boolean exclusiveMinimum = false;




    //getters and setters
    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public Number getMultipleOf() {
        return multipleOf;
    }

    public void setMultipleOf(Number multipleOf) {
        if(multipleOf.doubleValue() > 0) {
            this.multipleOf = multipleOf;
        }
    }

    public Number getMaximum() {
        return maximum;
    }

    public void setMaximum(Number maximum) {
        this.maximum = maximum;
    }

    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum;
    }

    //modified
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        if(maximum != null) {
            this.exclusiveMaximum = exclusiveMaximum;
        }
    }

    public Number getMinimum() {
        return minimum;
    }

    public void setMinimum(Number minimum) {
        this.minimum = minimum;
    }

    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum;
    }

    //modified
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        if(minimum != null) {
            this.exclusiveMinimum = exclusiveMinimum;
        }
    }
}
