//package com.ifsworld.rnd.intern.openapi.generator.metadata_parser;
//
//import com.ifsworld.rnd.intern.openapi.generator.common.ResourceLocator;
//import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.*;
//
//
//import java.io.File;
//import java.lang.String;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//
//public class XmlToJavaObjectTest {
//
//
//    public static void main(String[] args) {
//
//        //test "createJavaObject(File file)" method and "createUnmarshaller()"
//
////        File file = new File(ResourceLocator.findResource("test/metadata.xml",false));
////        System.out.println(file);
////
////
////        Edmx edmx = (Edmx) XmlToJavaObject.createJavaObject(file);
//
//
//        //test "createJavaObject(URL url)" method
//
//        String urlString = "http://localhost:56774/odata/$metadata";
//        URL url = null;
//        try {
//            url = new URL(urlString);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        Edmx edmx = (Edmx) XmlToJavaObject.createJavaObject(url);
//
//        System.out.println("Edmx = " +edmx);
//        System.out.println("Edmx: Version = " +edmx.getVersion());
//
//        DataServices dataServices = edmx.getDataServices();
//        System.out.println("DataServices = "+dataServices);
//
//        List<Schema> schemas = dataServices.getSchemas();
//        System.out.println("Schemas = "+schemas);
//        if (schemas != null) {
//            for (Schema schema : schemas) {
//                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//                System.out.println("Schema: " + schema);
//                System.out.println("Schema: Namespace = " + schema.getNamespace());
//
//                List<EntityType> entityTypes = schema.getEntityTypes();
//                System.out.println("Schema: EntityTypes = " + entityTypes);
//
//                System.out.println("List of Entity Types------------------------------------------------------------------------");
//                if (entityTypes != null) {
//                    for (EntityType entity : entityTypes) {
//                        System.out.println("========================================================================================");
//                        System.out.println("EntityType: Name = " + entity.getName());
//                        System.out.println("EntityType: HasStream = " + entity.getHasStream());
//                        System.out.println("EntityType: OpenType = " + entity.getOpenType());
//                        System.out.println("EntityType: BaseType = " + entity.getBaseType());
//
//                        Key key = entity.getKey();
//                        System.out.println("EntityType: Key = " + key);
//                        if (key != null) {
//                            PropertyRef propertyRef = key.getPropertyRef();
//                            System.out.println("EntityType: Key: PropertyRef = " + propertyRef);
//                            if (propertyRef != null) {
//                                System.out.println("EntityType: Key: PropertyRef: Name = " + propertyRef.getName());
//                            }
//                        }
//
//
//                        List<Property> propertyList = entity.getProperties();
//                        System.out.println("EntityType: PropertyList = " + propertyList);
//                        if (propertyList != null) {
//                            for (Property property : propertyList) {
//                                System.out.println("------------------------------------------------------------------------------------");
//                                System.out.println("EntityType: Property = " + property);
//                                System.out.println("EntityType: Property: Name = " + property.getName());
//                                System.out.println("EntityType: Property: Type = " + property.getType());
//                                System.out.println("EntityType: Property: Nullable = " + property.getNullable());
//                            }
//                        }
//
//
//                        List<NavigationProperty> navigationPropertyList = entity.getNavigationProperties();
//                        System.out.println("EntityType: NavigationPropertyList = " + navigationPropertyList);
//                        if (navigationPropertyList != null) {
//                            for (NavigationProperty navigationProperty : navigationPropertyList) {
//                                System.out.println("____________________________________________________________________________________");
//                                System.out.println("EntityType: NavigationProperty = " + navigationProperty);
//                                System.out.println("EntityType: NavigationProperty: Name = " + navigationProperty.getName());
//                                System.out.println("EntityType: NavigationProperty: Type = " + navigationProperty.getType());
//                                System.out.println("EntityType: NavigationProperty: Nullable = " + navigationProperty.getNullable());
//                            }
//                        }
//
//                    }
//                }
//
//            }
//        }
//    }
//
//}
