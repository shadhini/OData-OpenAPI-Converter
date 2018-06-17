package com.ifsworld.rnd.intern.openapi.generator.swagger.model;


import java.util.ArrayList;
import java.util.List;

public class Type implements IType{

    private String typeName;

    private String format;

    //Unlike JSON Schema, the value MUST conform to the defined type for the Schema Object
    private Type _default; //typeName has not been finalized ????????????????

    private List<String> enums;





    //getters and setters

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Type get_default() {
        return _default;
    }

    public void set_default(Type _default) {
        this._default = _default;
    }

    public List<String> getEnums() {
        return enums;
    }

    public void setEnums(List<String> enums) {
        this.enums = enums;
    }


    //methods to add elements to arrays
    public void addEnumMember(String enumMember){
        if(enums == null){
            enums = new ArrayList<String>();
        }
        enums.add(enumMember);
    }

}
