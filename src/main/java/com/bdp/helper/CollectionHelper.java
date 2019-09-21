
/***
 *
 * @ClassName: CollectionHelper
 * @Description: Collection工具类
 * @Auther: yecao
 * @Date: 2019/9/21 14:24
 * @version : 1.0
 */

package com.bdp.helper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CollectionHelper {


    /**
     * .将List<String>集合 转化为'1','2','3','4','5'
     * @param strlist 字符串LIST
     * @return 转换后的String
     */
    public static String convertListToString(List<String> strlist) {
        StringBuffer sb = new StringBuffer();
        if (CollectionUtils.isNotEmpty(strlist)) {
            for (int i = 0; i < strlist.size(); i++) {
                if (i == 0) {
                    sb.append("'").append(strlist.get(i)).append("'");
                } else {
                    sb.append(",").append("'").append(strlist.get(i)).append("'");
                }
            }
        }
        return sb.toString();
    }


    /***
     * 将"1,2,3,4,5..."这种形式的字符串转成List<String> 集合
     * @param strs 源字符串
     * @return
     * */

    public static List<String> converStringToList(String strs) {
        if (StringUtils.isNotBlank(strs)) {
            String[] idStrs = strs.trim().split(",");
            if (null != idStrs && idStrs.length > 0) {
                List<String> strsList = new ArrayList<String>();
                for (String str : idStrs) {
                    if (StringUtils.isNotBlank(str)) {
                        strsList.add(str.trim());
                    }
                }
                if (strsList.size() > 0) {
                    return strsList;
                }
            }
        }
        return null;
    }

    /**
     将"1,2,3,4,5..."这种形式的字符串转成"'1','2','3','4'..."这种形式
     @param strs
     @return
     */
    public static String converString(String strs) {
        if (StringUtils.isNotBlank(strs)) {
            String[] idStrs = strs.trim().split(",");
            if (null != idStrs && idStrs.length > 0) {
                StringBuffer sbf = new StringBuffer("");
                for (String str : idStrs) {
                    if (StringUtils.isNotBlank(str)) {
                        sbf.append("'").append(str.trim()).append("'").append(",");
                    }
                }
                if (sbf.length() > 0) {
                    sbf = sbf.deleteCharAt(sbf.length() - 1);
                    return sbf.toString();
                }
            }
        }
        return "";
    }
}
