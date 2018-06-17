package com.ifsworld.rnd.intern.openapi.generator.common;

public final class SwaggerKeys {


    //root level basic swagger keys
    public static final String SWAGGGER = "swagger";
    public static final String INFO = "info";
    public static final String SCHEMES = "schemes";
    public static final String HOST = "host";
    public static final String BASE_PATH = "basePath";
    public static final String CONSUMES = "consumes";
    public static final String PRODUCES = "produces";
    public static final String TAGS = "tags";
    public static final String PATHS = "paths";
    public static final String DEFINITIONS = "definitions";
    public static final String PARAMETERS = "parameters";
    public static final String RESPONSES = "responses";
    public static final String SECURITY_DEFINITIONS = "securityDefinitions";
    public static final String SECURITY = "security";
    public static final String EXTERNAL_DOCS = "externalDocs";

    public static final String TITLE = "title";
    public static final String VERSION = "version";
    public static final String DESCRIPTION = "description";
    public static final String NAME = "name";

    public static final String URL = "url";
    public static final String TERMS_OF_SERVICE = "termsOfService";
    public static final String EMAIL = "email";
    public static final String CONTACT = "contact";
    public static final String LICENSE = "license";

    public static final String OPERATION_ID = "operationId";
    public static final String DEPRECATED = "deprecated";

    public static final String NAMESPACE = "namespace";
    public static final String PREFIX = "prefix";
    public static final String ATTRIBUTE = "attribute";
    public static final String WRAPPED = "wrapped";

    public static final String HEADERS = "headers";

    //schema level swagger keys
    public static final String SCHEMA = "schema";
    public static final String TYPE = "type";
    public static final String FORMAT = "format";
    public static final String REFERENCE = "$ref";
    public static final String DEFAULT = "default";
    public static final String MULTIPLE_OF = "multipleOf";
    public static final String MAXIMUM = "maximum";
    public static final String EXCLUSIVE_MAXIMUM = "exclusiveMaximum";
    public static final String MINIMUM = "minimum";
    public static final String EXCLUSIVE_MINIMUM = "exclusiveMinimum";
    public static final String MAX_LENGTH = "maxLength";
    public static final String MIN_LENGTH = "minLength";
    public static final String PATTERN = "pattern";
    public static final String MAX_ITEMS = "maxItems";
    public static final String MIN_ITEMS = "minItems";
    public static final String UNIQUE_ITEMS = "uniqueItems";
    public static final String MAX_PROPERTIES = "maxProperties";
    public static final String MIN_PROPERTIES = "minProperties";
    public static final String REQUIRED = "required";
    public static final String ENUM = "enum";
    public static final String ITEMS = "items";
    public static final String ALL_OF = "allOf";
    public static final String PROPERTIES = "properties";
    public static final String ADDITIONAL_PROPERTIES = "additionalProperties";
    public static final String DISCRIMINATOR = "discriminator";
    public static final String READ_ONLY = "readOnly";
    public static final String XML = "xml" ;
    public static final String EXAMPLE = "example";

    //operation level swagger keys
    public static final String SUMMARY = "summary";





    //parameter specific swagger keys
    public static final String IN = "in";
    public static final String ALLOW_EMPTY_VALUE = "allowEmptyValue";
    public static final String COLLECTION_FORMAT = "collectionFormat";






    //HTTP verbs
    public static final String HTTP_GET = "get";
    public static final String HTTP_POST = "post";
    public static final String HTTP_PATCH = "patch";
    public static final String HTTP_PUT = "put";
    public static final String HTTP_DELETE = "delete";
    public static final String HTTP_OPTIONS = "options";
    public static final String HTTP_HEAD = "head";






    //swagger supportive Collection Formats
    public static final String CSV = "csv";
    public static final String SSV = "ssv";
    public static final String TSV = "tsv";
    public static final String PIPES = "pipes";





    //---------PrimitiveType Data Types that Swagger supports

    //number
    public static final String[] NUMBER = {"number"};

    //decimal
    public static final String[] DECIMAL = {"number","decimal"}; //oasis

    //int16
    public static final String[] INT16 = {"integer","int16"}; //oasis

    //integer : signed 32 bits
    public static final String[] INTEGER = {"integer","int32"}; //oasis

    //long : signed 64 bits
    public static final String[] LONG = {"integer", "int64"}; //oasis

    //double
    public static final String[] DOUBLE = {"number", "double"}; //oasis

    //SByte
    public static final String[] SBYTE = {"integer","int8"}; //oasis

    //float
    public static final String[] FLOAT = {"number","float"}; //oasis


    //string
    public static final String[] STRING = {"string"}; //oasis

    //byte : base64 encoded characters
    public static final String[] BYTE = {"integer","uint8"}; //oasis

    //binary : any sequence of octets
    public static final String[] BINARY = {"string","base64url"}; //oasis

    //boolean
    public static final String[] BOOLEAN = {"boolean"}; //oasis

    //date : as defined by full-date - RFC3339
    public static final String[] DATE = {"string", "date"}; //oasis

    //dateTime : as defined by date-time - RFC3339
    public static final String[] DATE_TIME = {"string", "date-time"}; // oasis

    //time of day
    public static final String[] TIME_OF_DAY = {"string", "time"}; // oasis

    //password : used to hint UIs the input needs to be obscured
    public static final String[] PASSWORD = {"string", "password"};



    //duration
    public static final String[] DURATION = {"string","duration"}; //oasis

    //guid
    public static final String[] GUID = {"string","uuid"}; //oasis




    //array
    public static final String ARRAY = "array";

    //object
    public static final String OBJECT = "object";




}
