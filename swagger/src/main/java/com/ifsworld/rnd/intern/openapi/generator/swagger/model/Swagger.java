package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import com.ifsworld.rnd.intern.openapi.generator.swagger.model.security.SecurityRequirement;
import com.ifsworld.rnd.intern.openapi.generator.common.ServiceRoot;

import java.util.ArrayList;
import java.util.List;

public class Swagger {

    //Singleton class instance
    private static Swagger instance;



    //required field and the default value is "2.0"
    private String swagger = "2.0";

    //required field and the default value has been set
    private Info info = Info.getInstance();

    //value of this field is set to authority component of the service root URL unless explicitly set otherwise
    private String host = ServiceRoot.getInstance().getServiceRootHost();

    //value of this field is set to path component of the service root URL unless explicitly set otherwise
    private String basePath = ServiceRoot.getInstance().getServiceRootPath();

    //value of this field is set to protocol component of the service root URL, other schemes can be added at the run time
    private List<String> schemes = new ArrayList<String>();

    private List<String> consumes = new ArrayList<String>();

    private List<String> produces =  new ArrayList<String>();

    //required field and the default value is an empty Paths object
    private Paths paths = Paths.getInstance();

    private Definitions definitions = Definitions.getInstance();

    private ParametersDefinitions parameters = ParametersDefinitions.getInstance();

    private ResponsesDefinitions responses = ResponsesDefinitions.getInstance();

    private SecurityDefinitions securityDefinitions = SecurityDefinitions.getInstance();

    private List<SecurityRequirement> security =  new ArrayList<SecurityRequirement>();

    private List<Tag> tags = new ArrayList<Tag>();

    private ExternalDocumentation externalDocs;









    //constructors

    private Swagger() {
        schemes.add(ServiceRoot.getInstance().getServiceRootScheme());
    }








    //getInstance method for the Singleton class

    public static Swagger getInstance(){
        if(instance == null){
            instance = new Swagger();
        }
        return instance;
    }











    //getters and setters

    public String getSwagger() {
        return swagger;
    }

    public void setSwagger(String swagger) {
        this.swagger = swagger;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public List<String> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<String> schemes) {
        this.schemes = schemes;
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

    public Paths getPaths() {
        return paths;
    }

    public void setPaths(Paths paths) {
        this.paths = paths;
    }

    public Definitions getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definitions definitions) {
        this.definitions = definitions;
    }

    public ParametersDefinitions getParameters() {
        return parameters;
    }

    public void setParameters(ParametersDefinitions parameters) {
        this.parameters = parameters;
    }

    public ResponsesDefinitions getResponses() {
        return responses;
    }

    public void setResponses(ResponsesDefinitions responses) {
        this.responses = responses;
    }

    public SecurityDefinitions getSecurityDefinitions() {
        return securityDefinitions;
    }

    public void setSecurityDefinitions(SecurityDefinitions securityDefinitions) {
        this.securityDefinitions = securityDefinitions;
    }

    public List<SecurityRequirement> getSecurity() {
        return security;
    }

    public void setSecurity(List<SecurityRequirement> security) {
        this.security = security;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }











    //adding elements to ArrayLists

    public void addScheme(String scheme){
        schemes.add(scheme);
    }

    public void addConsumeType(String consumeType){
        consumes.add(consumeType);
    }

    public void addProduceType(String produceType){
        produces.add(produceType);
    }

    public void addSecurityRequirement(SecurityRequirement securityRequirement){
        security.add(securityRequirement);
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }





    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }

}
