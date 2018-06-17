package com.ifsworld.rnd.intern.openapi.generator.odata_openapi_mapper;


import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.Annotation;
import com.ifsworld.rnd.intern.openapi.generator.metadata_parser.edm.TCollectionExpression;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public class AnnotationMapper {

    public static final String CORE_DESCRIPTION = "Core.Description";
    public static final String CAPABILITIES_SUPPORTED_FORMATS = "Capabilities.SupportedFormats";
    public static final String CORE_SCHEMA_VERSION = "Core.SchemaVersion";
    public static final String CORE_LONG_DESCRIPTION = "Core.LongDescription";


    public static Object findAnnotationTerm(List<Annotation> annotationList, String term){
        int count = 0;
        if(annotationList != null){
            while (count<annotationList.size()){
                findAnnotationTerm(annotationList.get(count),term);
                count += 1;
            }
        }

        return null;
    }

    public static Object findAnnotationTerm(Annotation annotation, String term){
        if(annotation.getTerm() != null) {
            switch (term) {
                case "Core.Description":
                    if (annotation.getTerm().matches(".*" + "Core" + ".*" + "Description")) {
                        return annotation.getString();
                    }

                case "Core.SchemaVersion":
                    if (annotation.getTerm().matches(".*" + "Core" + ".*" + "SchemaVersion")) {
                        return annotation.getString();
                    }

                case "Core.LongDescription":
                    if (annotation.getTerm().matches(".*" + "Core" + ".*" + "LongDescription")) {
                        return annotation.getString();
                    }

                case "Capabilities.SupportedFormats":
                    if (annotation.getTerm() != null && annotation.getTerm().matches(".*" + "Capabilities" + ".*" + "SupportedFormats")) {
                        List<String> valueList = null;
                        TCollectionExpression collection = annotation.getCollection();
                        if (collection != null && collection.getBinaryOrBoolOrDate() != null && collection.getBinaryOrBoolOrDate().size() > 0) {
                            valueList = new ArrayList<>();
                            for (JAXBElement<?> value : collection.getBinaryOrBoolOrDate()) {
                                valueList.add(value.toString());
                            }
                        }
                        return valueList;
                    }
            }
        }

        return null;
    }

}
