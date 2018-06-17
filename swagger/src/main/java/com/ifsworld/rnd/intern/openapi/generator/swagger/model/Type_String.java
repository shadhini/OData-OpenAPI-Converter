package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Type_String extends Type {

    private String value;

    //--------validation keywords for strings---------------------------------------------------------

    //must be greater than or equal to 0
    private Number maxLength;

    //must be greater than or equal to 0 and default value is set to 0
    private Number minLength = 0;

    //must be a regular expression, according to the EXMA 262 regular expression dialect
    private String pattern;



    //getters and setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Number getMaxLength() {
        return maxLength;
    }

    //modified
    public void setMaxLength(Number maxLength) {
        if(maxLength.intValue() >= 0) {
            this.maxLength = maxLength;
        }
    }

    public Number getMinLength() {
        return minLength;
    }

    //modified
    public void setMinLength(Number minLength) {
        if(minLength.intValue() >= 0 ) {
            this.minLength = minLength;
        }
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
