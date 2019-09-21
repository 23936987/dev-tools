package com.bdp.exception;

import com.bdp.helper.BaseHelper;
import com.bdp.helper.StringHelper;

/***
 *
 * @ClassName: Assert
 * @Description: TODO
 * @Auther: yecao
 * @Date: 2019/9/21 14:53
 * @version : 1.0
 */

public class Assert {
    //--------------------------isTrue----------------------------------------/
    public  static void isTrue(boolean flag,String errorMsg) throws BizException {
        if(!flag) {
            throw new BizException(errorMsg);
        }
    }
    public  static void isTrue(boolean flag,String errorMsg,String... params) throws BizException {
        String message = StringHelper.format(errorMsg,params);
        isTrue(flag,message);
    }
    public  static void isTrue(boolean flag,ErrorEnum errorEnum) throws BizException {
        if(!flag) {
            throw new BizException(errorEnum);
        }
    }
    public  static void isTrue(boolean flag,ErrorEnum errorEnum,String message) throws BizException {
        if(!flag) {
            throw new BizException(errorEnum,message);
        }
    }
    public  static void isTrue(boolean flag,ErrorEnum errorEnum,String errorMsg,String... params) throws BizException {
        String message = StringHelper.format(errorMsg,params);
        isTrue(flag,errorEnum,message);
    }

    //--------------------------isNotTrue----------------------------------------/
    public  static void isNotTrue(boolean flag,String errorMsg) throws BizException {
        isTrue(!flag,errorMsg);
    }
    public  static void isNotTrue(boolean flag,String errorMsg,String... params) throws BizException {
        String message = StringHelper.format(errorMsg,params);
        isTrue(flag,message);
    }
    public  static void isNotTrue(boolean flag,ErrorEnum errorEnum) throws BizException {
        isTrue(!flag,errorEnum);
    }
    public  static void isNotTrue(boolean flag,ErrorEnum errorEnum,String message) throws BizException {
       isTrue(!flag,errorEnum,message);
    }
    public  static void isNotTrue(boolean flag,ErrorEnum errorEnum,String errorMsg,String... params) throws BizException {
        isTrue(!flag,errorEnum,errorMsg,params);
    }
    //--------------------------isNull----------------------------------------/
    public  static void isNull(Object object,String errorMsg) throws BizException {
        isTrue(BaseHelper.isEmpty(object),errorMsg);
    }
    public  static void isNull(Object object,String errorMsg,String... params) throws BizException {
        String message = StringHelper.format(errorMsg,params);
        isTrue(BaseHelper.isEmpty(object),message);
    }
    public  static void isNull(Object object,ErrorEnum errorEnum) throws BizException {
        isTrue(BaseHelper.isEmpty(object),errorEnum);
    }
    public  static void isNull(Object object,ErrorEnum errorEnum,String message) throws BizException {
        isTrue(BaseHelper.isEmpty(object),errorEnum,message);
    }
    public  static void isNull(Object object,ErrorEnum errorEnum,String errorMsg,String... params) throws BizException {
        isTrue(BaseHelper.isEmpty(object),errorEnum,errorMsg,params);
    }
    //--------------------------isNotNull----------------------------------------/
    public  static void isNotNull(Object object,String errorMsg) throws BizException {
        isTrue(BaseHelper.isNotEmpty(object),errorMsg);
    }
    public  static void isNotNull(Object object,String errorMsg,String... params) throws BizException {
        String message = StringHelper.format(errorMsg,params);
        isTrue(BaseHelper.isNotEmpty(object),message);
    }
    public  static void isNotNull(Object object,ErrorEnum errorEnum) throws BizException {
        isTrue(BaseHelper.isNotEmpty(object),errorEnum);
    }
    public  static void isNotNull(Object object,ErrorEnum errorEnum,String message) throws BizException {
        isTrue(BaseHelper.isNotEmpty(object),errorEnum,message);
    }
    public  static void isNotNull(Object object,ErrorEnum errorEnum,String errorMsg,String... params) throws BizException {
        isTrue(BaseHelper.isNotEmpty(object),errorEnum,errorMsg,params);
    }
}



