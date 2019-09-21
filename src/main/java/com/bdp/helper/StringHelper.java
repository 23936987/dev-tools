/***
 *
 * @ClassName: StringHelper
 * @Description: 字符串工具类
 * @Auther: yecao
 * @Date: 2019/9/21 14:24
 * @version : 1.0
 */
package com.bdp.helper;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class StringHelper {

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

    public static String format(String content, Map<String, String> map) {
        Set<Map.Entry<String, String>> sets = map.entrySet();
        for (Map.Entry<String, String> entry : sets) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll(entry.getValue());
        }
        return content;
    }

    public static String format(String content, String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            String val = arr[i];
            String regex = "\\$\\{" + i + "\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll(val);
        }

        return content;
    }
}
