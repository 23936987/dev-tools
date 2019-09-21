package com.bdp.helper;

import java.util.Random;
import java.util.UUID;

/***
 *
 * @ClassName: RandomHelper
 * @Description: 主键生成工具类
 * @Auther: yecao
 * @Date: 2019/9/21 14:30
 * @version : 1.0
 */

public class PrimaryKeyHelper {

    public static final char[] n = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    public static final char[] b = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    public static final char[] c = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Z', 'Y', 'Z' };
    public static final char[] s = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P','Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Z', 'Y', 'Z' };
    public static final char[] sc = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P','Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Z', 'Y', 'Z', '=', '/', '+', '-', '*', '_', '~', '!', '#', '@', '%', '^', '&', '(', ')', '|', '.', '`', ':' };

    /**
     * 获取只有大写字母的16位uuid
     * @return
     */
    public static String getUUID16(){
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer time =new StringBuffer(String.valueOf(System.currentTimeMillis() - 1501257600000L));
        Random random = new Random();
        while (time.length()<16){
            time.insert(random.nextInt(time.length()),base.charAt(random.nextInt(26)));
        }
        return time.toString().replace("-","X");
    }

    /**
     * 获取大写的32位uuid
     * @return
     */
    public static String getUUID32() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    /**
     * 获取一个固定长度的随机整数
     *
     * @param size:数字长度
     * @return String
     */
    public static String getRandomNumber(int size) {
        StringBuffer sb = new StringBuffer();
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(n[rd.nextInt(n.length)]);
        }
        return sb.toString();
    }

    /**
     * 获取一个随机的字符串,包括数字,小写英文字母和大写英文字母
     *
     * @param size:字符串长度
     * @param withNumber:是否包含数字
     * @return String
     */
    public static String getRandomString(int size, boolean withNumber) {
        StringBuffer sb = new StringBuffer();
        Random rd = new Random();
        if (withNumber) {
            for (int i = 0; i < size; i++) {
                sb.append(s[rd.nextInt(s.length)]);
            }
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(c[rd.nextInt(c.length)]);
            }
        }
        return sb.toString();
    }

    /**
     * 获取一个随机的字符串,含有特殊字符
     * @param size 字符串长度
     * @return String
     */
    public static String getRandomStringWithSpecialChar(int size) {
        StringBuffer sb = new StringBuffer();
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(sc[rd.nextInt(sc.length)]);
        }
        return sb.toString();
    }

    /**
     * 获取指定长度的随机小写英文字母
     * @param size
     * @return
     */
    public static String getRandomLowercaseString(int size) {
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(b[rd.nextInt(b.length)]);
        }
        return sb.toString();
    }

    /**
     * 获取指定长度的随机大写英文字母
     * @param size
     * @return
     */
    public static String getRandomUppercaseString(int size) {
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(b[rd.nextInt(b.length)]);
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 获取一个双精度随机数
     *
     * @return Double
     */
    public static Double getRandomDouble() {
        return Math.random();
    }

    /**
     * 获取UUID
     *
     * @return String
     */
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 获取某个区间的整形
     *
     * @param min:最小值
     * @param max:最大值
     * @return int
     */
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 获取一个随机整形值
     *
     * @return int
     */
    public static int getRandomInt() {
        Random random = new Random();
        return random.nextInt();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(PrimaryKeyHelper.getUUID32());
        }
    }
}



