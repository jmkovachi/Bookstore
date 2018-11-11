package org.csci4050.bookstore.Bookstore.util;

import java.util.List;

public class SqlUtil {

    public static String columnAndValue(final String column, final String value) {
        return column + " = \"" + value + "\",";
    }


    public static String createSqlUpdateString(final String table, final List<ColumnValue> columnValues) {
        final StringBuilder sql = new StringBuilder("update " + table + " set ");
        sql.append(ColumnValue.columnValueString(columnValues));
        return sql.toString();
    }
}
