package org.csci4050.bookstore.Bookstore.util;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ColumnValue {
    private String column;
    private String value;

    public static ColumnValue columnValue(final String column, final String value) {
        return ColumnValue.builder()
                .column(column)
                .value("\"" + value + "\"")
                .build();
    }

    public static ColumnValue columnValue(final String column, final Integer value) {
        return ColumnValue.builder()
                .column(column)
                .value(value.toString())
                .build();
    }

    public static String columnValueString(final List<ColumnValue> columnValues) {
        final StringBuilder str = new StringBuilder();
        for (int i = 0; i < columnValues.size()-1; i++) {
            str.append(columnValues.get(i).toString());
            str.append(",");
        }
        str.append(columnValues.get(columnValues.size()-1).toString());
        return str.toString();
    }

    @Override
    public String toString() {
        return column + " = " + value;
    }
}
