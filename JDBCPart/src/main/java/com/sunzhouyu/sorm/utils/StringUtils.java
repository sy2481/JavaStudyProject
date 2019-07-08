package com.sunzhouyu.sorm.utils;

/**
 * 封装了字符串常用的操作
 *
 * @author sunyi
 */
public class StringUtils {
    public static String firstChar2UpperCase(String tname) {
        return tname.toUpperCase().substring(0, 1) + tname.substring(1);
    }
}
