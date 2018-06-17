package com.ifsworld.rnd.intern.openapi.generator.metadata_parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JavaObjectToXml {

    public static void createXML(Object object){


        try {
            //creating Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            StringWriter result = new StringWriter();
            jaxbMarshaller.marshal(object,result);

            //Printing XML
            String xml = result.toString();
            System.out.println(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
