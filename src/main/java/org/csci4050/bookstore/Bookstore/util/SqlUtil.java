package org.csci4050.bookstore.Bookstore.util;

import java.util.Date;

public class SqlUtil {

    public static String columnAndValue(final String column, final String value) {
        return column + " = \"" + value + "\",";
    }

    public static String convertJavaDateToSQL(final Date date) {
        return new java.sql.Date(date.getTime()).toString();
    }
}
