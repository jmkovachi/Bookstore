package org.csci4050.bookstore.Bookstore.util;

public class MapperUtil {

    public static boolean convertBitToBool(final int bool) {
        return bool == 1;
    }
    public static int convertBoolToBit(final boolean bool) {
        return bool ? 1 : 0;
    }
}
