/**
 * Json工具类
 * <p>完成日期：2018年11月27日</p>
 *
 * @version 1.0
 */

package com.bdp.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

public class JsonHelper {
    public static SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.DisableCircularReferenceDetect};

    /**
     * String 字符串转对象
     * @param json 字符串
     * @return 对象
     */
    public static Object toJSonString(String json) {
        return JSON.parseObject(json);
    }

    /**
     *  String 字符串转对象
     * @param json json字符串
     * @param clazz T 类型
     * @param <T> 类型对象
     * @return 对象
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     *  对象转字符串
     * @param object 对象
     * @return 字符串
     */
    public static String toJSonString(Object object) {
        return JSON.toJSONString(object, features);
    }

    /**
     *  字符串转对象数组
     * @param json  json字符串
     * @param clazz T 类型
     * @param <T> 类型对象
     * @return 对象列表
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    /**
     * 将Map下JSONObject和JSONArray类型处理
     * @param map  map类型
     * @param clazz T 类型
     * @param <T> 类型对象
     * @return Map
     */
    public static <T> Map<String, T> fromJson2Map(Map<String, Object> map, Class<T> clazz) {
        Map<String, T> res = new HashMap<>();
        if (map != null && map.size() > 0) {
            Set<Map.Entry<String, Object>> entrys = map.entrySet();
            for (Iterator<Map.Entry<String, Object>> it = entrys.iterator(); it.hasNext(); ) {
                Map.Entry<String, Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                T model = JSON.parseObject(toJSonString(value), clazz);
                res.put(key, model);
            }
        }
        return res;
    }

    /**
     * 将Map下JSONObject和JSONArray类型处理
     * @param map map类型
     * @return Map
     */
    public static HashMap<String, Object> fromJson2Map(Map<String, Object> map) {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for (Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            if (map.get(key) instanceof JSONArray) {
                JSONArray value = (JSONArray) map.get(key);
                List list = handleJSONArray(value);
                resultMap.put(key, list);
            } else {
                resultMap.put(key, map.get(key));
            }
        }
        return resultMap;
    }

    /**
     *
     * @param jsonArray 列表
     * @return 对象Map列表
     */
    public static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray) {
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap map = new HashMap<String, Object>();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (entry.getValue() instanceof JSONArray) {
                    map.put((String) entry.getKey(), handleJSONArray((JSONArray) entry.getValue()));
                } else {
                    map.put((String) entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
    }

}
