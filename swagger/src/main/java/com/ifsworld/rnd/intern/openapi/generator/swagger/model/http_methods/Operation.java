package com.ifsworld.rnd.intern.openapi.generator.swagger.model.http_methods;

import com.ifsworld.rnd.intern.openapi.generator.swagger.model.ExternalDocumentation;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.IParameter;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.Responses;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.security.SecurityRequirement;

import java.util.ArrayList;
import java.util.List;

public abstract class Operation {

    protected List<String> tags = new ArrayList<String>();

    protected String summary;

    protected String description;

    protected ExternalDocumentation externalDocs;

    protected String operationId;

    protected List<String> consumes;

    protected List<String> produces;

    protected List<IParameter> parameters =  new ArrayList<IParameter>();

    //required field
    protected Responses responses = new Responses();

    protected List<String> schemes;

    protected Boolean deprecated;

    protected List<SecurityRequirement> security;






    //getters and setters


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public List<String> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<String> consumes) {
        this.consumes = consumes;
    }

    public List<String> getProduces() {
        return produces;
    }

    public void setProduces(List<String> produces) {
        this.produces = produces;
    }

    public List<IParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<IParameter> parameters) {
        this.parameters = parameters;
    }

    public Responses getResponses() {
        return responses;
    }

    public void setResponses(Responses responses) {
        this.responses = responses;
    }

    public List<String> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<String> schemes) {
        this.schemes = schemes;
    }

    public Boolean getIsDeprecated() {
        return deprecated;
    }

    public void setIsDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public List<SecurityRequirement> getSecurity() {
        return security;
    }

    public void setSecurity(List<SecurityRequirement> securityRequirements) {
        this.security = securityRequirements;
    }


    //methods to add elements to lists
    public void addTag(String tag){
        tags.add(tag);
    }

    public void addConsumeType(String mediaType){
        if(consumes == null){
            consumes =  new ArrayList<String>();
        }
        consumes.add(mediaType);
    }

    public void addProduceType(String mediaType){
        if(produces == null){
            produces = new ArrayList<String>();
        }
        produces.add(mediaType);
    }

    public void addParameter(IParameter parameter){
        parameters.add(parameter);
    }

    public void addScheme(String scheme){
        if(schemes == null){
            schemes =  new ArrayList<String>();
        }
        schemes.add(scheme);
    }

    public void addSecurityRequirement(SecurityRequirement securityRequirement){
        if(security == null){
            security =  new ArrayList<SecurityRequirement>();
        }
        security.add(securityRequirement);
    }
}
