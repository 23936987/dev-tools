/***
 *
 * @ClassName: IMapGetter
 * @Description: 基础工具类包
 * @Auther: yecao
 * @Date: 2019/9/21 14:24
 * @version : 1.0
 */
package com.bdp.map;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  自定义Map接口
 *  实现些接口的Map将扩展一些有用的获取Map值的方法
 * <p>完成日期：2018年04月04日</p>
 *
 * @version 1.0
 */
public interface IMapGetter {

    Object getByKey(String key);

    <T> T getObjectByKey(String key, Class<T> clz);

    <T> List<T> getListByKey(String key, Class<T> clz);
    List<Map<String, Object>> getListWithMapByKey(String key);
    <T> List<Map<String, T>> getListWithMapByKey(String key, Class<T> clz);


    Map<String,Object> getMapByKey(String key);
    <T> Map<String,T> getMapByKey(String key, Class<T> clz);
    <T> Map<String,Object> getMapQueryByKey(String key, Class<T> clz);

    QuickValueMap getQuickValueMap(String key);


    Boolean getBooleanByKey(String key);
    Boolean getBooleanByKey(String key, Boolean def);

    String getStringByKey(String key);
    String getStringByKey(String key, String def);

    Integer getIntByKey(String key);
    Integer getIntByKey(String key, Integer def);

    Long getLongByKey(String key);
    Long getLongByKey(String key, Long def);


    Float getFloatByKey(String key);
    Float getFloatByKey(String key, Float def);

    Double getDoubleByKey(String key);
    Double getDoubleByKey(String key, Double def);

    BigDecimal getBigDecimalByKey(String key);
    BigDecimal getBigDecimalByKey(String key, String def);

    Date getDateByKey(String key);
    Date getDateByKey(String key, String format);
}
