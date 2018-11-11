package org.csci4050.bookstore.Bookstore.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColumnValue {
    private String column;
    private String value;

    @Override
    public String toString() {
        return column + " = " + value + ",";
    }
}
