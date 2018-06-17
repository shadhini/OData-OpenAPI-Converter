package com.ifsworld.rnd.intern.openapi.generator.swagger.model;



public abstract class Schema implements ISchema,IDefinition,IX_Patterned{

    private String title;

    private String description;

    private String discriminator;

    //this field has no effect on root schemas, this is relevant only for properties schemas
    private Boolean readOnly = false;

    //this field has no effect on root schemas, this is relevant only for properties schemas
    private XML xml;

    private ExternalDocumentation externalDoc;

    //this field is not finalized yet
    private ISchema example;




    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public XML getXml() {
        return xml;
    }

    public void setXml(XML xml) {
        this.xml = xml;
    }

    public ExternalDocumentation getExternalDoc() {
        return externalDoc;
    }

    public void setExternalDoc(ExternalDocumentation externalDoc) {
        this.externalDoc = externalDoc;
    }


    public ISchema getExample() {
        return example;
    }

    public void setExample(ISchema example) {
        this.example = example;
    }
}
