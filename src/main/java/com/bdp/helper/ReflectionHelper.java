package com.bdp.helper;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * java反射工具类
 * <p>完成日期：2016年10月21日</p>
 *
 * @version 1.0
 */

@SuppressWarnings("unchecked")
public class ReflectionHelper {

    /**
     * 获取泛型参数类型
     * @param clazz 类类型
     * @param <T> 类类型
     * @return 对象类型
     */
    public static <T> Class<T> getClassGenricType(final Class clazz) {
        return getClassGenricType(clazz, 0);
    }

    /**
     * 获取泛型参数类型
     * @param clazz 类类型
     * @param index 参数索引
     * @return 类类型
     */
    public static Class getClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    /**
     *  获取方法对象
     * @param clazz 类类型
     * @param methodName 方法名
     * @param parameterTypes 类型
     * @return 方法
     */
    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?> ... parameterTypes){
        Method method = null ;

        for( ; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes) ;
                return method ;
            } catch (Exception e) {
            }
        }

        return null;
    }
    /**
     * 循环向上转型, 获取对象的 DeclaredField
     * @param clazz : 子类对象
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static Field getDeclaredField(Class<?> clazz, String fieldName){
        Field field = null ;
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName) ;
                return field ;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了

            }
        }
        return null;
    }

    public static List<Field> getDeclaredFields(Class<?> clazz){

        List<Field> fields = new ArrayList<Field>();
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                Field[] arr = clazz.getDeclaredFields();
                if(arr != null && arr.length>0){
                    for (int i = 0; i < arr.length; i++) {
                        if(!contains(fields,arr[i])){
                            fields.add(arr[i]);
                        }

                    }
                }
            } catch (Exception e) {
            }
        }
        return fields;
    }

    private static boolean contains(List<Field> fields, Field field) {
        if(fields == null || fields.size() == 0) return false;
        if(field == null) return  false;

        for (int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            if(f.getName().equalsIgnoreCase(field.getName())){
                return true;
            }
        }
        return false;
    }

    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object.getClass(), fieldName);
        field.setAccessible(true);

        try {
            String e = field.getType().getName();
            if("java.lang.String".equalsIgnoreCase(e)) {
                field.set(object, value);
            } else if("java.lang.Integer".equalsIgnoreCase(e)) {
                Integer val = Integer.valueOf(String.valueOf(value));
                field.set(object, val);
            }else if("java.lang.Long".equalsIgnoreCase(e)) {
                Long val = Long.valueOf(String.valueOf(value));
                field.set(object, val);
            }else if("java.math.BigDecimal".equalsIgnoreCase(e)) {
                BigDecimal val = new BigDecimal(String.valueOf(value));
                val.setScale(2);
                field.set(object, val);
            }else{
                field.set(object, value);
            }

        } catch (IllegalArgumentException var6) {
            var6.printStackTrace();
        } catch (IllegalAccessException var7) {
            var7.printStackTrace();
        }

    }

    public static Object getFieldValue(Object object, String fieldName) {
        Field field = getDeclaredField(object.getClass(), fieldName);
        field.setAccessible(true);

        try {
            return field.get(object);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static Object getFieldValue(Class clazz, String prop, Object value) {
        String val = String.valueOf(value);
        Object res = null;
        Field field = getDeclaredField(clazz, prop);
        String fieldType = field.getType().getName();
        if("java.lang.Integer".equalsIgnoreCase(fieldType)) {
            res = Integer.valueOf(val);
        } else if("java.lang.Short".equalsIgnoreCase(fieldType)) {
            res = Short.valueOf(val);
        } else if("java.lang.Long".equalsIgnoreCase(fieldType)) {
            res = Long.valueOf(val);
        } else if("java.lang.Double".equalsIgnoreCase(fieldType)) {
            res = Double.valueOf(val);
        } else if("java.lang.Float".equalsIgnoreCase(fieldType)) {
            res = Float.valueOf(val);
        } else {
            res = value;
        }

        return res;
    }
}
