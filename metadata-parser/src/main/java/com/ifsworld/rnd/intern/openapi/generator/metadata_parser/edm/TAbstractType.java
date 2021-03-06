//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.17 at 04:17:04 PM IST 
//


package com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAbstractType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TAbstractType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Edm.ComplexType"/>
 *     &lt;enumeration value="Edm.EntityType"/>
 *     &lt;enumeration value="Edm.PrimitiveType"/>
 *     &lt;enumeration value="Edm.Geography"/>
 *     &lt;enumeration value="Edm.Geometry"/>
 *     &lt;enumeration value="Edm.AnnotationPath"/>
 *     &lt;enumeration value="Edm.NavigationPropertyPath"/>
 *     &lt;enumeration value="Edm.PropertyPath"/>
 *     &lt;enumeration value="Collection(Edm.ComplexType)"/>
 *     &lt;enumeration value="Collection(Edm.EntityType)"/>
 *     &lt;enumeration value="Collection(Edm.PrimitiveType)"/>
 *     &lt;enumeration value="Collection(Edm.Geography)"/>
 *     &lt;enumeration value="Collection(Edm.Geometry)"/>
 *     &lt;enumeration value="Collection(Edm.AnnotationPath)"/>
 *     &lt;enumeration value="Collection(Edm.NavigationPropertyPath)"/>
 *     &lt;enumeration value="Collection(Edm.PropertyPath)"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TAbstractType")
@XmlEnum
public enum TAbstractType {

    @XmlEnumValue("Edm.ComplexType")
    EDM_COMPLEX_TYPE("Edm.ComplexType"),
    @XmlEnumValue("Edm.EntityType")
    EDM_ENTITY_TYPE("Edm.EntityType"),
    @XmlEnumValue("Edm.PrimitiveType")
    EDM_PRIMITIVE_TYPE("Edm.PrimitiveType"),
    @XmlEnumValue("Edm.Geography")
    EDM_GEOGRAPHY("Edm.Geography"),
    @XmlEnumValue("Edm.Geometry")
    EDM_GEOMETRY("Edm.Geometry"),
    @XmlEnumValue("Edm.AnnotationPath")
    EDM_ANNOTATION_PATH("Edm.AnnotationPath"),
    @XmlEnumValue("Edm.NavigationPropertyPath")
    EDM_NAVIGATION_PROPERTY_PATH("Edm.NavigationPropertyPath"),
    @XmlEnumValue("Edm.PropertyPath")
    EDM_PROPERTY_PATH("Edm.PropertyPath"),
    @XmlEnumValue("Collection(Edm.ComplexType)")
    COLLECTION_EDM_COMPLEX_TYPE("Collection(Edm.ComplexType)"),
    @XmlEnumValue("Collection(Edm.EntityType)")
    COLLECTION_EDM_ENTITY_TYPE("Collection(Edm.EntityType)"),
    @XmlEnumValue("Collection(Edm.PrimitiveType)")
    COLLECTION_EDM_PRIMITIVE_TYPE("Collection(Edm.PrimitiveType)"),
    @XmlEnumValue("Collection(Edm.Geography)")
    COLLECTION_EDM_GEOGRAPHY("Collection(Edm.Geography)"),
    @XmlEnumValue("Collection(Edm.Geometry)")
    COLLECTION_EDM_GEOMETRY("Collection(Edm.Geometry)"),
    @XmlEnumValue("Collection(Edm.AnnotationPath)")
    COLLECTION_EDM_ANNOTATION_PATH("Collection(Edm.AnnotationPath)"),
    @XmlEnumValue("Collection(Edm.NavigationPropertyPath)")
    COLLECTION_EDM_NAVIGATION_PROPERTY_PATH("Collection(Edm.NavigationPropertyPath)"),
    @XmlEnumValue("Collection(Edm.PropertyPath)")
    COLLECTION_EDM_PROPERTY_PATH("Collection(Edm.PropertyPath)");
    private final String value;

    TAbstractType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TAbstractType fromValue(String v) {
        for (TAbstractType c: TAbstractType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
