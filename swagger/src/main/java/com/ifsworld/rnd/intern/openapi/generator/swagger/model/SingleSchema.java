package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class SingleSchema extends Schema {

    private IType typeOrReference;

    //constructors


    public SingleSchema() {
    }

    public SingleSchema(IType typeOrReference) {
        this.typeOrReference = typeOrReference;
    }


    //getters and setters


    public IType getTypeOrReference() {
        return typeOrReference;
    }

    public void setTypeOrReference(IType typeOrReference) {
        this.typeOrReference = typeOrReference;
    }
}
