package com.bdp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 字符串工具类
 * <p>完成日期：2016年10月21日</p>
 *
 * @version 1.0
 */
public class StringHelper {
	/**
     * 判定对象是否为空
     * @param object 待判断对象
     * @return true 是 false 否
     */
    public static boolean isEmpty(Object object) {
        if (null == object) return true;

        if (object instanceof String) {
            String str = String.valueOf(object);
            if (str.trim().length() == 0) return true;
            if (str.trim().equals("null")) return true;
        }
        return false;
    }
    /**
     * 判定对象是否非空
     * @param object 待判断对象
     * @return true 是 false 否
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    /**
     * 驼峰标识转下划线变量变量
     * @param str 驼峰标识
     * @return 下划线变量
     */
    public static String parseCol(String str) {
        Pattern p = Pattern.compile("([a-z\\d]+)([A-Z])");
        Matcher m = p.matcher(str);
        return m.replaceAll("$1_$2").toLowerCase();
    }

    /**
     * 下划线变量转驼峰标识变量
     * @param str 下划线变量
     * @return 驼峰标识
     */
    public static String parseTuo(String str) {
        str = str.toLowerCase();
        String[] arr = str.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(captureName(arr[i]));
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     * @param str
     * @return 首字母大写
     */
    public static String captureName(String str) {
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        return str;
    }


    public static boolean isBlank(CharSequence str) {

        return false;
    }
    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") =》 this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param params 参数值
     * @return 格式化后的文本
     */
    public static String format(CharSequence template, Object... params) {
        return "";
    }
}
