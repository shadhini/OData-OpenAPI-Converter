package com.ifsworld.rnd.intern.openapi.generator.webapp;

import com.ifsworld.rnd.intern.openapi.generator.odata_openapi_mapper.SwaggerSpecGenerator;
import com.ifsworld.rnd.intern.openapi.generator.common.ServiceRoot;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.XmlToJavaObject;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Edmx;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet("/openAPIgenerator")
public class MainServlet extends HttpServlet {

   private static String pathToSwaggerFile;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlString = request.getParameter("serviceRoot");
        String metadataString = request.getParameter("metadataDoc").toString();

        pathToSwaggerFile = this.getServletContext().getRealPath("swagger/swagger.json");
        System.out.println("Path to swagger.json file : " + pathToSwaggerFile);


        System.out.println("Url string: " + urlString);

        Edmx edmx;

        if(metadataString != null  && metadataString.trim().length()>0 && !metadataString.contains(System.getProperty("line.separator"))) {
            edmx = (Edmx) XmlToJavaObject.createJavaObject(metadataString);
            ServiceRoot.getInstance().setCurrentServiceRoot("http://www.ifsworld.com/lk");
        }else{
            edmx = parseODataServiceMetadata(urlString);
            ServiceRoot.getInstance().setCurrentServiceRoot(urlString);
        }

        if (edmx != null){
            System.out.println("Successfully parsed the OData service's metadata");
        }else {
            System.out.println("An error occurred while parsing the OData service's metadata");
        }

        SwaggerSpecGenerator.generateSwaggerObject(edmx, pathToSwaggerFile);

        System.out.println("swagger.jsp file will be loaded now");

        RequestDispatcher dispatcher = request.getRequestDispatcher("swagger.jsp");
        dispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public Edmx parseODataServiceMetadata(String serviceRoot){
        URL url = null;
        try {
            url = new URL(serviceRoot+"/$metadata");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Edmx edmx = (Edmx) XmlToJavaObject.createJavaObject(url);

        return edmx;
    }

    public static JsonObject read(){


        System.out.println("Resource path: " + pathToSwaggerFile);

        try {
            JsonReader jsonReader = Json.createReader(new FileReader(pathToSwaggerFile));
            JsonObject swaggerObject = jsonReader.readObject();
            System.out.println(swaggerObject);
            jsonReader.close();
            return swaggerObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
