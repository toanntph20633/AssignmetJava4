package com.example.assignmetjava4.utilities;

public class UtilClass {
    public static boolean checkEmpty(String... strings) {
        for (String s : strings) {
            if ("".equals(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSo(String... strings) {
        for (String s : strings) {
            try {
                Integer.parseInt(s);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
