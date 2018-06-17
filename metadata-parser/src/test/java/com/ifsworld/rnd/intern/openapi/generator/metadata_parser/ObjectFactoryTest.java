//package com.ifsworld.rnd.intern.openapi.generator.metadata_parser;
//
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.DataServices;
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Edmx;
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Schema;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ObjectFactoryTest {
//    public static void main(String[] args) {
//
//        List<Schema> schemas= new ArrayList<Schema>();
//
//        Schema schema = ObjectFactory.createSchema();
//        schema.setNamespace("com.ifsworld.rnd.intern.testNamespace");
//        schemas.add(schema);
//
//        DataServices dataServices = ObjectFactory.createDataServices();
//        dataServices.setSchemas(schemas);
//
//        Edmx edmx = ObjectFactory.createEdmx();
//        edmx.setVersion("testVersion:0.0.0");
//        edmx.setDataServices(dataServices);
//
//
//        System.out.println("Created Edmx object: " + edmx);
//        System.out.println("Edmx: Version attribute: " + edmx.getVersion());
//        System.out.println("Edmx: DataServices element: " + edmx.getDataServices());
//        System.out.println("Created DataServices object: " + edmx.getDataServices());
//        System.out.println("DataServices: Schema element: " + edmx.getDataServices().getSchemas());
//        System.out.println("Created Schema object: " + edmx.getDataServices().getSchemas().get(0));
//        System.out.println("Schema: Namespace attribute: " + edmx.getDataServices().getSchemas().get(0).getNamespace());
//    }
//}
