OData to OpenAPI Converter 
============================
OData to OpenAPI Converter generates Swagger specification for a given OData service and visualizes the generated Swagger specification through a Swagger UI.

## Prerequisites

### Once per computer

  - Install [Java SE 8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  - Install [MAVEN 3+](https://maven.apache.org/)
  - Install [Tomcat 7+](https://tomcat.apache.org/)
  
### Once per repository

Clone down this repository by issuing the following command 
```
git clone http://rndgitlab.corpnet.ifsworld.com/shjylk/open-api-spec-generator.git
```

## Building

Go to the folder which contains the cloned repository and open a terminal.

Then navigate to the `%REPOSITORY_ROOT%/odata-openapi-converter` folder
```
cd odata-openapi-converter
```

Run the following command to compile the code
```
mvn clean install
```

## Deploying the tool on Tomcat server

Copy the **openAPIgenerator.war** file at `%REPOSITORY_ROOT%/odata-openapi-converter/webapp/target` to `%CATALINA_HOME%\webapps` (E.g.: C:\tomcat\webapps) 

Run 
```
%CATALINA_HOME%\bin\startup.bat
```

The .war file will be extracted to a folder which has the same name as the .war file’s name 

Go to `%CATALINA_HOME%\conf\server.xml` and take the port for the HTTP protocol. <Connector port="8080" ... />. The default value is **8080**.

Go to a browser and access the following URL.
```
http://localhost:8080/openAPIgenerator/
```

## Usage 

Insert **either** a service root URL of an existing OData service to **“Service Root:”** field or metadata document which describes the data model of a OData service as a string to **“Metadata:”** field as the input.

### Option 1: 

  - Insert service root URL of an existing OData service. 
  - Then click the **“Generate SWAGGER UI”** button. 
 
### Option 2: 

  - Insert a metadata document of a OData service as a string.
  - Then click the **“Generate SWAGGER UI”** button. 
 


Now the tool will render the Swagger UI which describes the capabilities of the OData service you provided.

 
You can view the description for an operation just by clicking on an endpoint.

There is a **“Try it Out”** button for each operation. By clicking on that, you can send requests to each endpoint with required parameters, through this interface.

## Important

**“Try it Out”** feature will work only if
  - You have given the service root URL of an actual OData service as the input.
  - The OData service hosted at the given URL support the CORS (Cross Origin Resource Sharing).

Swagger specification generated for the given OData service which is in JSON format is available at the following URL after you generate the Swagger UI by clicking the **“Generate SWAGGER UI”** button.
```
http://localhost:8080/openAPIgenerator/swagger/swagger.json 
```


