package com.ifsworld.rnd.intern.openapi.generator.swagger.model;


//a singleton class
public class Info {


    //Singleton class instance
    private static Info instance;

    //required field and the default value has been set.
    private String title = "Open API specification";

    private String description;

    private String termsOfService;

    private Contact contact;

    private License license;

    //required field and the default value is set to "*"
    private String version = "*";







    //constructors
    private Info(){

    }







    //getInstance method for the Singleton class

    public static Info getInstance(){
        if(instance == null){
            instance = new Info();
        }
        return instance;
    }








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

    public String getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



    //this clears the existing singleton object
    public static void clear(){
        instance = null;
    }

}
