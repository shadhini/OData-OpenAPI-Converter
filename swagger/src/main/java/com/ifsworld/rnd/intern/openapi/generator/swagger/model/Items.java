package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

public class Items{


    private IType typeOrReference;

    //constructor
    public Items(IType typeOrReference) {
        setTypeOrReference(typeOrReference);
    }


    //getters and setters

    public IType getTypeOrReference() {
        return typeOrReference;
    }

    //modified, so that items won't contain a description if it is a Schema
    public void setTypeOrReference(IType typeOrReference) {
        this.typeOrReference = typeOrReference;
    }
}

