package com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "DataServices",namespace = "http://docs.oasis-open.org/odata/ns/edmx")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(factoryClass = ObjectFactory.class, factoryMethod = "createDataServices")
@XmlSeeAlso({Schema.class})
public class DataServices {

    @XmlElement(name = "Schema", namespace = "http://docs.oasis-open.org/odata/ns/edm")
    private List<Schema> schemas;

    public List<Schema> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<Schema> schemas) {
        this.schemas = schemas;
    }
}
