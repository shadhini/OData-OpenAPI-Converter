package com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Edmx", namespace = "http://docs.oasis-open.org/odata/ns/edmx")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlSeeAlso({Reference.class})
@XmlType(factoryClass = ObjectFactory.class, factoryMethod = "createEdmx")
public class Edmx{

    @XmlAttribute(name = "Version")
    private String Version;

    @XmlElement(name = "DataServices", namespace = "http://docs.oasis-open.org/odata/ns/edmx")
    private DataServices dataServices;

//    @XmlElement(name = "Reference", namespace = "http://docs.oasis-open.org/odata/ns/edmx")
//    private List<Reference> references;



    public DataServices getDataServices() {
        return dataServices;
    }

    public void setDataServices(DataServices dataServices) {
        this.dataServices = dataServices;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

//    public List<Reference> getReferences() {
//        return references;
//    }
//
//    public void setReferences(List<Reference> references) {
//        this.references = references;
//    }
}
