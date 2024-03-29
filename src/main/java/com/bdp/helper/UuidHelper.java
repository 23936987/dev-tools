/***
 *
 * @ClassName: UuidHelper
 * @Description: uuid工具类
 * @Auther: yecao
 * @Date: 2019/9/21 14:24
 * @version : 1.0
 */
package com.bdp.helper;

import java.security.SecureRandom;
import java.util.UUID;

public class UuidHelper {
    /**
     * 无参构造方法
     */
    public UuidHelper(){
    }
    /**
     * 随机变量
     */
    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     * @return UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     * @return GUID
     */
    public static String GUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 使用SecureRandom随机生成Long.
     * @return long
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

}
