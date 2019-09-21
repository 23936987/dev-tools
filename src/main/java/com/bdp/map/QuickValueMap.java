package com.bdp.map;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bdp.helper.*;

import java.math.BigDecimal;
import java.util.*;

/**
 *  扩展HashMap

 * <p>完成日期：2018年04月04日</p>
 *
 * @version 1.0
 */

public class QuickValueMap extends HashMap<String,Object> implements IMapGetter {

    public QuickValueMap(){
    }
    public QuickValueMap(Map map){
        this.putAll(map);
    }

    @Override
    public Boolean getBooleanByKey(String key) {
        String str = getStringByKey(key);
        if(str != null){
            return Boolean.valueOf(str);
        }
        return null;
    }

    @Override
    public Boolean getBooleanByKey(String key, Boolean def) {
        String str = getStringByKey(key);
        if(str != null){
            return Boolean.valueOf(str);
        }
        return def;
    }

    /**
     * 查询字符串
     * @param key 键
     * @return 值
     */
    @Override
    public String getStringByKey(String key) {

        try {
            Object value = get(key);
            if (BaseHelper.isEmpty(value)) {
                return null;
            }
            if(value instanceof JSONObject){
                return JsonHelper.toJSonString(value);
            }

            if(value instanceof JSONArray){
                return JsonHelper.toJSonString(value);
            }

            if(value instanceof Integer
                    || value instanceof Byte
                    || value instanceof Short
                    || value instanceof Long
                    || value instanceof Double
                    || value instanceof String
                    || value instanceof Float
                    || value instanceof Boolean
                    ){
                return String.valueOf(value);
            }

            return JsonHelper.toJSonString(value);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 查询字符串,如果值为空,返回默认值
     * @param key 键
     * @param def 默认值
     * @return 值
     */
    @Override
    public String getStringByKey(String key, String def) {
        String str = getStringByKey(key);
        if(str != null){
            return str;
        }
        return def;
    }


    /**
     * 查询长整型
     * @param key 键
     * @return 值
     */
    @Override
    public Long getLongByKey(String key) {
        String str = getStringByKey(key,null);
        if(str != null){
            try {
                return Long.valueOf(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public Long getLongByKey(String key, Long def) {
        Long value = getLongByKey(key);
        if(value != null){
            return value;
        }
        return def;
    }

    @Override
    public Date getDateByKey(String key) {
        return getDateByKey(key, Constant.DEFAULT_DATETIME_FORMART);
    }

    /**
     *
     * @param key
     * @param format
     * @return
     */
    @Override
    public Date getDateByKey(String key, String format) {
        String str = getStringByKey(key);
        if(BaseHelper.isNotEmpty(str)){
           return  DateHelper.strToDate(str,format);
        }
        return null;
    }


    /**
     * 查询整型
     * @param key 键
     * @return 值
     */
    @Override
    public Integer getIntByKey(String key) {
        String str = getStringByKey(key,null);
        if(str != null){
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public Integer getIntByKey(String key, Integer def) {
        Integer value = getIntByKey(key);

        if(value != null){
            return value;
        }
        return def;
    }

    /**
     * 查询浮点型
     * @param key 键
     * @return 值
     */
    @Override
    public Float getFloatByKey(String key) {
        String str = getStringByKey(key,null);
        if(str != null){
            try {
                return Float.valueOf(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public Float getFloatByKey(String key, Float def) {
        Float value = getFloatByKey(key);
        if(value != null){
            return value;
        }
        return def;
    }


    /**
     * 查询浮点型
     * @param key 键
     * @return 值
     */
    @Override
    public Double getDoubleByKey(String key) {
        String str = getStringByKey(key,null);
        if(str != null){
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
    /**
     * 查询浮点型
     * @param key 键
     * @param def 默认值
     * @return 值
     */
    @Override
    public Double getDoubleByKey(String key,Double def) {
        Double value = getDoubleByKey(key);
        if(value != null){
            return value;
        }
        return def;
    }
    @Override
    public BigDecimal getBigDecimalByKey(String key, String def) {
        Object value = get(key);
        if (BaseHelper.isEmpty(value)) {
            if (def == null) {
                return null;
            }
            return new BigDecimal(def);
        }
        return new BigDecimal(value.toString());
    }
    @Override
    public BigDecimal getBigDecimalByKey(String key) {
        return getBigDecimalByKey(key, "0");
    }

    @Override
    public Object getByKey(String key) {
        return this.get(key);
    }

    @Override
    public <T> T getObjectByKey(String key, Class<T> clz){

        //参数校验
        if(BaseHelper.isEmpty(key)) {
            return null;
        }
        if(BaseHelper.isEmpty(clz)) {
            return null;
        }
        Object value = get(key);
        if (BaseHelper.isEmpty(value)) {
            return null;
        }
        if (value instanceof String) {
            T o =  parseObject(String.valueOf(value), clz);
            return o;
        } else if (value instanceof JSONObject) {
            T o = parseObject(JsonHelper.toJSonString(value), clz);
            return o;
        } else {
            T o =parseObject(JsonHelper.toJSonString(value), clz);
            return o;
        }
    }
    @Override
    public Map<String,Object> getMapByKey(String key){
        Map<String,Object> map = getObjectByKey(key,Map.class);

        if (map != null){
            return fromJson2Map(map);
        }
        return null;
    }

    @Override
    public <T> Map<String, T> getMapByKey(String key, Class<T> clz) {
        Map<String,Object> map = getObjectByKey(key,Map.class);
        if (map != null){
            return fromJson2Map(map,clz);
        }
        return null;
    }

    @Override
    public <T> Map<String, Object> getMapQueryByKey(String key, Class<T> clz) {
        Map<String,Object> map = getObjectByKey(key,Map.class);
        if (map != null){
            return fromJson2MapValue(map, clz);
        }
        return null;
    }

    @Override
    public QuickValueMap getQuickValueMap(String key) {
        Map<String,Object> map = getMapByKey(key);
        return new QuickValueMap(map);
    }

    private <T> Map<String, Object> fromJson2MapValue(Map<String, Object> map, Class<T> clz) {

        Map<String,Object>  res = new HashMap<>();
        if(map != null && map.size()>0){
            Set<Entry<String,Object>> entrys = map.entrySet();
            for(Iterator<Entry<String,Object>> it = entrys.iterator();it.hasNext();){
                Entry<String,Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();

                if (BaseHelper.isEmpty(value)) {
                    res.put(key,value);
                }

                if(value instanceof Integer
                        || value instanceof Byte
                        || value instanceof Short
                        || value instanceof Long
                        || value instanceof Double
                        || value instanceof String
                        || value instanceof Float
                        || value instanceof Boolean
                        ){
                    res.put(key,value);
                }


                if(value instanceof JSONObject){
                    T model = JSON.parseObject(JsonHelper.toJSonString(value),clz);
                    res.put(key,model);
                }
            }
        }
        return res;
    }


    @Override
    public <T> List<T> getListByKey(String key, Class<T> clz) {
        //参数校验
        if(BaseHelper.isEmpty(key)) {
            return null;
        }
        if(BaseHelper.isEmpty(clz)) {
            return null;
        }
        Object value = get(key);
        if (BaseHelper.isEmpty(value)) {
            return null;
        }
        if (value instanceof String) {
            List<T> list = JSON.parseArray(String.valueOf(value), clz);
            return list;
        } else if (value instanceof JSONArray) {
            List<T> list = JSON.parseArray(JsonHelper.toJSonString(value), clz);
            return list;
        } else {
            List<T> list = JSON.parseArray(JsonHelper.toJSonString(value), clz);
            return list;
        }
    }

    @Override
    public List<Map<String, Object>> getListWithMapByKey(String key) {
        //参数校验
        if(BaseHelper.isEmpty(key)) {
            return null;
        }
        return getListWithMapByKey(key, Object.class);
    }

    @Override
    public <T> List<Map<String, T>> getListWithMapByKey(String key, Class<T> clz) {
        //参数校验
        if(BaseHelper.isEmpty(key)) {
            return null;
        }
        if(BaseHelper.isEmpty(clz)) {
            return null;
        }
        List<Map> list = getListByKey(key, Map.class);
        List<Map<String, T>> result = new ArrayList<Map<String, T>>();

        if(BaseHelper.isEmpty(list) || list.size() ==0) {
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            Map map = list.get(i);
            Map<String, T> res = new HashMap<String, T>();
            Set<Entry<String,Object>> entrySet = map.entrySet();

            for(Iterator<Entry<String,Object>> it = entrySet.iterator();it.hasNext();){
                Entry<String,Object> entry = it.next();
                String keyName= entry.getKey();
                Object value = entry.getValue();
                if(value instanceof JSONObject){
                    JSONObject jsonObject = (JSONObject) value;
                    T t = JSON.parseObject(jsonObject.toJSONString(),clz);
                    res.put(keyName,t);
                }else{
                    res.put(keyName,(T)value);
                }
            }
            result.add(res);
        }
        return result;
    }

    private <T> T parseObject(String str, Class<T> clz) {
        return JSON.parseObject(str,clz);
    }

    private <T> Map<String, T> fromJson2Map(Map<String,Object> map,Class<T> clz) {
        Map<String, T>  res = new HashMap<>();
        if(map != null && map.size()>0){
            Set<Entry<String,Object>> entrys = map.entrySet();
            for(Iterator<Entry<String,Object>> it = entrys.iterator();it.hasNext();){
                Entry<String,Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                T model = JSON.parseObject(JsonHelper.toJSonString(value), clz);
                res.put(key,model);
            }
        }
        return res;
    }
    private HashMap<String, Object> fromJson2Map(Map<String,Object> map) {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for(Iterator iter = map.keySet().iterator(); iter.hasNext();){
            String key = (String)iter.next();
            if(map.get(key) instanceof JSONArray){
                JSONArray value = (JSONArray)map.get(key);
                List list = handleJSONArray(value);
                resultMap.put(key, list);
            } else{
                resultMap.put(key, map.get(key));
            }
        }
        return resultMap;
    }
    private  List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray){
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap map = new HashMap<String, Object>();
            for (Entry entry : jsonObject.entrySet()) {
                if(entry.getValue() instanceof  JSONArray){
                    map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
                }else{
                    map.put((String)entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
    }

    public String toJson(){
       return JsonHelper.toJSonString(this);
    }
    public static QuickValueMap restoreJson(String jsonData){
        return new QuickValueMap(JSON.parseObject(jsonData));
    }
}
