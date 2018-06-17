//package com.ifsworld.rnd.intern.openapi.generator.metadata_parser;
//
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.DataServices;
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Edmx;
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.EntityType;
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Schema;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class JavaObjectToXmlTest {
//    public static void main(String[] args) {
//        Edmx edmx = new Edmx();
//        DataServices dataServices = new DataServices();
//        EntityType entityType = new EntityType();
//        entityType.setName("TestEntity");
//
//        List<EntityType> entityTypes = new ArrayList<EntityType>();
//        List<Schema> schemas = new ArrayList<Schema>();
//        Schema schema = new Schema();
//        schema.setNamespace("com.ifsworld.rnd.intern.testNamespace");
//        entityTypes.add(entityType);
//        schema.setEntityTypes(entityTypes);
//        schemas.add(schema);
//        dataServices.setSchemas((List<Schema>) schemas);
//
//        edmx.setDataServices(dataServices);
//
//        JavaObjectToXml.createXML(edmx);
//
//    }
//}
