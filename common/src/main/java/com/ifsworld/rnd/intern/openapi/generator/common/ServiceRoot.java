package com.ifsworld.rnd.intern.openapi.generator.common;

import java.net.MalformedURLException;
import java.net.URL;

public class ServiceRoot {

    private static ServiceRoot instance = null;

    private String defaultServiceRoot = "unknown service root";

    private URL currentServiceRoot;

    //read only attribute
    private String serviceRootScheme;

    //read only attribute
    private String serviceRootHost;

    //read only attribute
    private String serviceRootPath;


    //private constructor
    private ServiceRoot(){
    }

    //getInstance method
    public static ServiceRoot getInstance(){
        if(instance == null){
            instance = new ServiceRoot();
        }
        return instance;
    }


    //getters and setters

    public String getDefaultServiceRoot() {
        return defaultServiceRoot;
    }

    public void setDefaultServiceRoot(String defaultServiceRoot) {
        this.defaultServiceRoot = defaultServiceRoot;
    }

    //modified
    public String getCurrentServiceRoot() {

        if (currentServiceRoot != null ) {
            return currentServiceRoot.toString();
        }else {
            return defaultServiceRoot;
        }
    }

    public void setCurrentServiceRoot(String currentServiceRoot) {
        try {
            this.currentServiceRoot = new URL(currentServiceRoot);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //modified
    public String getServiceRootScheme() {
        if(currentServiceRoot != null){
            return currentServiceRoot.getProtocol().toString();
        }else {
            return  null;
        }

    }

    //modified
    public String getServiceRootHost() {
        if(currentServiceRoot != null){
            return currentServiceRoot.getAuthority().toString();
        }else {
            return  null;
        }
    }

    //modified
    public String getServiceRootPath() {
        if(currentServiceRoot != null){
            return currentServiceRoot.getPath().toString();
        }else {
            return  null;
        }
    }

}
