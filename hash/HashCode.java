package com.pingan.qhzx.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peijian280 on 17/1/16.
 */
public class HashCode {
    public static void main(String[] args) {
        String[] strArray = {"a", "b", "c", "d", "e", "f"};
//        putValueInHashMap();
//        testSameKeyAddHashMap();
        testSameIndexAddArray();
    }


    public static void putValueInHashMap() {
        String[] strArray = {"a", "b", "c", "d", "e", "f"};
        for(String str:strArray) {
            int strHashCode = str.hashCode();
            int index = strHashCode % strArray.length;
            strArray[index] = "value";
        }
        for(String str : strArray) {
            System.out.println(str);
        }
    }

    public static String getValueInHashMap() {
        String[] strArray = {"a", "b", "c", "d", "e", "f"};
        for(String str:strArray) {
            int strHashCode = str.hashCode();
            int index = strHashCode % strArray.length;
            return strArray[index];
        }
        return "";
    }

    private static void testSameKeyAddHashMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a","ab");
        map.put("a","cd");
        System.out.println(map.get("a"));
    }

    private static  void testSameIndexAddArray() {
        String[] str = new String[10];
        str[0] = "str0";
        str[1] = "str1";
        str[0] = "str2";
        System.out.println(str[0]);
    }

    public static void test() {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        map.put(1, "a");
        map.put(1, "b");
    }
}
