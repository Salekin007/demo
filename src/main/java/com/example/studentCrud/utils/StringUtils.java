package com.example.studentCrud.utils;

import java.util.Objects;

public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return Objects.nonNull(str) && str.trim().length() > 0;
    }

    public static boolean nonNull(Object boj) {
        return Objects.nonNull(boj);
    }
    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }


}
