package org.csci4050.bookstore.Bookstore.util;

public class SqlUtil {

    public static String columnAndValue(final String column, final String value) {
        return column + " = " + value + ",";
    }


    public static String createSqlUpdateString(final String table, final ColumnValue... columnValues) {
        final StringBuilder sql = new StringBuilder("update " + table + " set ");
        for (final ColumnValue cv : columnValues) {
            sql.append(cv.toString());
        }
        return sql.toString();
    }
}
