package com.ifsworld.rnd.intern.openapi.generator.metadata_parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

public class XmlToJavaObject {


    //take the XML file from the file specified and create the corresponding Java Object
    public static Object createJavaObject(File file){
        XmlToJavaObject xmlToJavaObject = new XmlToJavaObject();
        Unmarshaller unmarshaller = xmlToJavaObject.createUnmarshaller();

        try {
            return unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    //take the XML file from a given URL and create the corresponding Java Object
    public static Object createJavaObject(URL url){
        XmlToJavaObject xmlToJavaObject = new XmlToJavaObject();
        Unmarshaller unmarshaller = xmlToJavaObject.createUnmarshaller();

        try {
            return unmarshaller.unmarshal(url);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }


    //take the XML file from a inputStream and create the corresponding Java Object
    public static Object createJavaObject(InputStream inputStream){
        XmlToJavaObject xmlToJavaObject = new XmlToJavaObject();
        Unmarshaller unmarshaller = xmlToJavaObject.createUnmarshaller();

        try {
            return unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    //take the XMl file from a string and create the corresponding Java Object
    public static Object createJavaObject(String input){
        XmlToJavaObject xmlToJavaObject = new XmlToJavaObject();
        Unmarshaller unmarshaller = xmlToJavaObject.createUnmarshaller();
        StreamSource streamSource = new StreamSource(new StringReader(input));

        try {
            return unmarshaller.unmarshal(streamSource);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;

    }


    //create JAXB Unmarshaller, using JAXBContext of the package
    //this is more trustworthy way; since custom namespace mappings in package-info.java file may not be taken into the consideration
    // if jaxbContext object is created from the specific object class instead of the package
    public Unmarshaller createUnmarshaller(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm");
            return jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
