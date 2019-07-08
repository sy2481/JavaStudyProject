package com.sunzhouyu.sorm.core;

/**
 * mysql数据类型和java数据类型的转换
 *
 * @author gaoqi
 */
public class MySqlTypeConvertor implements TypeConvertor {

    @Override
    public String databaseType2JavaType(String columnType) {

        //varchar-->String
        if ("varchar".equalsIgnoreCase(columnType) || "char".equalsIgnoreCase(columnType)) {
            return "String";
        } else if ("int".equalsIgnoreCase(columnType)
                || "tinyint".equalsIgnoreCase(columnType)
                || "smallint".equalsIgnoreCase(columnType)
                || "integer".equalsIgnoreCase(columnType)
                ) {
            return "Integer";
        } else if ("bigint".equalsIgnoreCase(columnType)) {
            return "Long";
        } else if ("double".equalsIgnoreCase(columnType) || "float".equalsIgnoreCase(columnType)) {
            return "Double";
        } else if ("clob".equalsIgnoreCase(columnType)) {
            return "java.sql.CLob";
        } else if ("blob".equalsIgnoreCase(columnType)) {
            return "java.sql.BLob";
        } else if ("date".equalsIgnoreCase(columnType)) {
            return "java.sql.Date";
        } else if ("time".equalsIgnoreCase(columnType)) {
            return "java.sql.Time";
        } else if ("timestamp".equalsIgnoreCase(columnType) || "dateTime".equalsIgnoreCase(columnType)) {
            return "java.sql.Timestamp";
        } else if ("text".equalsIgnoreCase(columnType)) {
            return "String";
        }

        return null;
    }

    @Override
    public String javaType2DatabaseType(String javaDataType) {
        return null;
    }

}
