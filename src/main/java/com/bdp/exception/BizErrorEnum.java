package com.bdp.exception;

/***
 *
 * @ClassName: BizErrorCode
 * @Description: TODO
 * @Auther: yecao
 * @Date: 2019/9/21 14:49
 * @version : 1.0
 */

public enum BizErrorEnum implements ErrorEnum {
    OK("0", "正常"),
    UNKONW("-1", "其它异常");

    private String errorCode;
    private String errorMsg;

    private BizErrorEnum(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}



