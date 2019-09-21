package com.bdp.exception;

/***
 *
 * @ClassName: BizException
 * @Description: 基础异常
 * @Auther: yecao
 * @Date: 2019/9/21 14:45
 * @version : 1.0
 */

public class BizException extends Exception{
    private String errorCode;
    private String errorMsg;
    public BizException(){
        ErrorEnum errorEnum = BizErrorEnum.UNKONW;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
    }
    public BizException(String errorMsg){
        ErrorEnum errorEnum = BizErrorEnum.UNKONW;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorMsg;
    }
    public BizException(ErrorEnum errorEnum) {
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
    }

    public BizException(ErrorEnum errorEnum, String errorMsg) {
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}



