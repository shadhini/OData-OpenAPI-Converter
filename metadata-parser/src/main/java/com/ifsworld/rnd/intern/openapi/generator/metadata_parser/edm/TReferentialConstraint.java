//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.17 at 04:17:04 PM IST 
//


package com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TReferentialConstraint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TReferentialConstraint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/odata/ns/edm}Annotation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Property" use="required" type="{http://docs.oasis-open.org/odata/ns/edm}TPath" />
 *       &lt;attribute name="ReferencedProperty" use="required" type="{http://docs.oasis-open.org/odata/ns/edm}TPath" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TReferentialConstraint", propOrder = {
    "annotation"
})
public class TReferentialConstraint {

    @XmlElement(name = "Annotation")
    protected List<Annotation> annotation;
    @XmlAttribute(name = "Property", required = true)
    protected String property;
    @XmlAttribute(name = "ReferencedProperty", required = true)
    protected String referencedProperty;

    /**
     * Gets the value of the annotation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the annotation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnotation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Annotation }
     * 
     * 
     */
    public List<Annotation> getAnnotation() {
        if (annotation == null) {
            annotation = new ArrayList<Annotation>();
        }
        return this.annotation;
    }

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperty(String value) {
        this.property = value;
    }

    /**
     * Gets the value of the referencedProperty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencedProperty() {
        return referencedProperty;
    }

    /**
     * Sets the value of the referencedProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencedProperty(String value) {
        this.referencedProperty = value;
    }

}
