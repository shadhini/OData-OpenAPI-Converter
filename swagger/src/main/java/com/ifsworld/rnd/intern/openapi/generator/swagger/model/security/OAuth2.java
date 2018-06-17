package com.ifsworld.rnd.intern.openapi.generator.swagger.model.security;

public class OAuth2 extends SecurityScheme {

    public static final String OAUTH2_IMPLICIT = "implicit";
    public static final String OAUTH2_ACCESS_CODE= "accessCode";
    public static final String OAUTH2_PASSWORD = "password";
    public static final String OAUTH2_APPLICATION = "application";


    //required field
    private String flow;

    //required field
    private String authorizationUrl;

    //required field
    private String tokenUrl;

    //required field
    private Scopes scopes;


    //getters and setters

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        if(this.flow == "implicit" || this.flow == "accessCode" ) {
            this.authorizationUrl = authorizationUrl;
        }
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        if(this.flow == "password" || this.flow == "application" || this.flow == "accessCode") {
            this.tokenUrl = tokenUrl;
        }
    }

    public Scopes getScopes() {
        return scopes;
    }

    public void setScopes(Scopes scopes) {
        this.scopes = scopes;
    }
}
