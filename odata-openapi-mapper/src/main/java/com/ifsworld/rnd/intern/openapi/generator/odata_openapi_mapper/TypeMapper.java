package com.ifsworld.rnd.intern.openapi.generator.odata_openapi_mapper;

import com.ifsworld.rnd.intern.openapi.generator.common.SwaggerKeys;
import com.ifsworld.rnd.intern.openapi.generator.swagger.model.*;

public class TypeMapper {

    public static SingleSchema mapPrimitiveProperties(String edmType){

        SingleSchema schema  =  new SingleSchema();
        //yet to complete

        switch (edmType){
            case "Edm.Binary":
                Type_String binaryType = new Type_String();
                binaryType.setTypeName(SwaggerKeys.BINARY[0]);
                binaryType.setFormat(SwaggerKeys.BINARY[1]);
                schema.setTypeOrReference(binaryType);
                return schema;
            case "Edm.Boolean":
                Type_Custom booleanType = new Type_Custom();
                booleanType.setTypeName(SwaggerKeys.BOOLEAN[0]);
                schema.setTypeOrReference(booleanType);
                return schema;
            case "Edm.Byte":
                Type_NumberOrInteger byteType = new Type_NumberOrInteger();
                byteType.setTypeName(SwaggerKeys.BYTE[0]);
                byteType.setFormat(SwaggerKeys.BYTE[1]);
                schema.setTypeOrReference(byteType);
                return schema;
            case "Edm.Date":
                Type_String dateType = new Type_String();
                dateType.setTypeName(SwaggerKeys.DATE[0]);
                dateType.setFormat(SwaggerKeys.DATE[1]);
                schema.setTypeOrReference(dateType);
                return schema;
            case "Edm.DateTimeOffset":
                Type_String dateTimeType = new Type_String();
                dateTimeType.setTypeName(SwaggerKeys.DATE_TIME[0]);
                dateTimeType.setFormat(SwaggerKeys.DATE_TIME[1]);
                schema.setTypeOrReference(dateTimeType);
                return schema;
            case "Edm.Decimal":
                Type_NumberOrInteger decimalType = new Type_NumberOrInteger();
                decimalType.setTypeName(SwaggerKeys.DECIMAL[0]);
                decimalType.setFormat(SwaggerKeys.DECIMAL[1]);
                schema.setTypeOrReference(decimalType);
                return schema;
            case "Edm.Double":
                Type_NumberOrInteger doubleType =  new Type_NumberOrInteger();
                doubleType.setTypeName(SwaggerKeys.DOUBLE[0]);
                doubleType.setFormat(SwaggerKeys.DOUBLE[1]);
                schema.setTypeOrReference(doubleType);
                return schema;
            case "Edm.Duration":
                Type_String durationType = new Type_String();
                durationType.setTypeName(SwaggerKeys.DURATION[0]);
                durationType.setFormat(SwaggerKeys.DURATION[1]);
                schema.setTypeOrReference(durationType);
                return schema;
            case "Edm.Guid":
                Type_String guidType = new Type_String();
                guidType.setTypeName(SwaggerKeys.GUID[0]);
                guidType.setFormat(SwaggerKeys.GUID[1]);
                schema.setTypeOrReference(guidType);
                return schema;
            case "Edm.Int16":
                Type_NumberOrInteger int16Type = new Type_NumberOrInteger();
                int16Type.setTypeName(SwaggerKeys.INT16[0]);
                int16Type.setFormat(SwaggerKeys.INT16[1]);
                schema.setTypeOrReference(int16Type);
                return schema;
            case "Edm.Int32":
                Type_NumberOrInteger intType = new Type_NumberOrInteger();
                intType.setTypeName(SwaggerKeys.INTEGER[0]);
                intType.setFormat(SwaggerKeys.INTEGER[1]);
                schema.setTypeOrReference(intType);
                return schema;
            case "Edm.Int64":
                Type_NumberOrInteger longType = new Type_NumberOrInteger();
                longType.setTypeName(SwaggerKeys.LONG[0]);
                longType.setFormat(SwaggerKeys.LONG[1]);
                schema.setTypeOrReference(longType);
                return schema;
            case "Edm.SByte":
                Type_NumberOrInteger sByteType = new Type_NumberOrInteger();
                sByteType.setTypeName(SwaggerKeys.SBYTE[0]);
                sByteType.setFormat(SwaggerKeys.SBYTE[1]);
                schema.setTypeOrReference(sByteType);
                return schema;
            case "Edm.Single":
                Type_NumberOrInteger singleType = new Type_NumberOrInteger();
                singleType.setTypeName(SwaggerKeys.FLOAT[0]);
                singleType.setFormat(SwaggerKeys.FLOAT[1]);
                schema.setTypeOrReference(singleType);
                return schema;
            case "Edm.String":
                Type_String stringType = new Type_String();
                stringType.setTypeName(SwaggerKeys.STRING[0]);
                schema.setTypeOrReference(stringType);
                return schema;
            case "Edm.TimeOfDay":
                Type_String timeOfDayType =  new Type_String();
                timeOfDayType.setTypeName(SwaggerKeys.TIME_OF_DAY[0]);
                timeOfDayType.setFormat(SwaggerKeys.TIME_OF_DAY[1]);
                schema.setTypeOrReference(timeOfDayType);
                return schema;
            case "object":
                Type_Object typeObject = new Type_Object();
                typeObject.setValue(new OBJECT());
                typeObject.setTypeName(SwaggerKeys.OBJECT);
                schema.setTypeOrReference(typeObject);
                return schema;
            case "array":
                Type_Array typeArray = new Type_Array();
                typeArray.setValue(new ARRAY());
                typeArray.setTypeName(SwaggerKeys.ARRAY);
                schema.setTypeOrReference(typeArray);
                return  schema;
            default:
                return schema;
        }

    }


    public static Type createType(String edmType){


        switch (edmType){
            case "Edm.Binary":
                Type_String binaryType = new Type_String();
                binaryType.setTypeName(SwaggerKeys.BINARY[0]);
                binaryType.setFormat(SwaggerKeys.BINARY[1]);
                return binaryType;
            case "Edm.Boolean":
                Type_Custom booleanType = new Type_Custom();
                booleanType.setTypeName(SwaggerKeys.BOOLEAN[0]);
                return booleanType;
            case "Edm.Byte":
                Type_NumberOrInteger byteType = new Type_NumberOrInteger();
                byteType.setTypeName(SwaggerKeys.BYTE[0]);
                byteType.setFormat(SwaggerKeys.BYTE[1]);
                return byteType;
            case "Edm.Date":
                Type_String dateType = new Type_String();
                dateType.setTypeName(SwaggerKeys.DATE[0]);
                dateType.setFormat(SwaggerKeys.DATE[1]);
                return dateType;
            case "Edm.DateTimeOffset":
                Type_String dateTimeType = new Type_String();
                dateTimeType.setTypeName(SwaggerKeys.DATE_TIME[0]);
                dateTimeType.setFormat(SwaggerKeys.DATE_TIME[1]);
                return dateTimeType;
            case "Edm.Decimal":
                Type_NumberOrInteger decimalType = new Type_NumberOrInteger();
                decimalType.setTypeName(SwaggerKeys.DECIMAL[0]);
                decimalType.setFormat(SwaggerKeys.DECIMAL[1]);
                return decimalType;
            case "Edm.Double":
                Type_NumberOrInteger doubleType =  new Type_NumberOrInteger();
                doubleType.setTypeName(SwaggerKeys.DOUBLE[0]);
                doubleType.setFormat(SwaggerKeys.DOUBLE[1]);
                return doubleType;
            case "Edm.Duration":
                Type_String durationType = new Type_String();
                durationType.setTypeName(SwaggerKeys.DURATION[0]);
                durationType.setFormat(SwaggerKeys.DURATION[1]);
                return durationType;
            case "Edm.Guid":
                Type_String guidType = new Type_String();
                guidType.setTypeName(SwaggerKeys.GUID[0]);
                guidType.setFormat(SwaggerKeys.GUID[1]);
                return guidType;
            case "Edm.Int16":
                Type_NumberOrInteger int16Type = new Type_NumberOrInteger();
                int16Type.setTypeName(SwaggerKeys.INT16[0]);
                int16Type.setFormat(SwaggerKeys.INT16[1]);
                return int16Type;
            case "Edm.Int32":
                Type_NumberOrInteger intType = new Type_NumberOrInteger();
                intType.setTypeName(SwaggerKeys.INTEGER[0]);
                intType.setFormat(SwaggerKeys.INTEGER[1]);
                return intType;
            case "Edm.Int64":
                Type_NumberOrInteger longType = new Type_NumberOrInteger();
                longType.setTypeName(SwaggerKeys.LONG[0]);
                longType.setFormat(SwaggerKeys.LONG[1]);
                return longType;
            case "Edm.SByte":
                Type_NumberOrInteger sByteType = new Type_NumberOrInteger();
                sByteType.setTypeName(SwaggerKeys.SBYTE[0]);
                sByteType.setFormat(SwaggerKeys.SBYTE[1]);
                return sByteType;
            case "Edm.Single":
                Type_NumberOrInteger singleType = new Type_NumberOrInteger();
                singleType.setTypeName(SwaggerKeys.FLOAT[0]);
                singleType.setFormat(SwaggerKeys.FLOAT[1]);
                return singleType;
            case "Edm.String":
                Type_String stringType = new Type_String();
                stringType.setTypeName(SwaggerKeys.STRING[0]);
                return stringType;
            case "Edm.TimeOfDay":
                Type_String timeOfDayType =  new Type_String();
                timeOfDayType.setTypeName(SwaggerKeys.TIME_OF_DAY[0]);
                timeOfDayType.setFormat(SwaggerKeys.TIME_OF_DAY[1]);
                return timeOfDayType;
            case "object":
                Type_Object typeObject = new Type_Object();
                typeObject.setValue(new OBJECT());
                typeObject.setTypeName(SwaggerKeys.OBJECT);
                return typeObject;
            case "array":
                Type_Array typeArray = new Type_Array();
                typeArray.setValue(new ARRAY());
                typeArray.setTypeName(SwaggerKeys.ARRAY);
                return  typeArray;
            default:
                return new Type_Custom();
        }

    }



}
