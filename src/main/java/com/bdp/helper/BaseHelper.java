/***
 *
 * @ClassName: BaseHelper
 * @Description: 基础工具类包
 * @Auther: yecao
 * @Date: 2019/9/21 14:24
 * @version : 1.0
 */
package com.bdp.helper;

import java.util.HashMap;
import java.util.Map;

public class BaseHelper {
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
     * 数据转为MAP,用于可变长参数
     * @param args
     * @return
     */
    public static Map<String, Object> array2map(Object[] args) {

        Map<String, Object> result = new HashMap<String, Object>();
        if (args == null || args.length % 2 == 0) {
            int len = args.length;

            for (int i = 0; i < len / 2; ++i) {
                int keyIndex = i * 2;
                int valueIndex = i * 2 + 1;
                Object key = args[keyIndex];
                Object value = args[valueIndex];
                result.put(String.valueOf(key), value);
            }
        }

        return result;
    }
}
