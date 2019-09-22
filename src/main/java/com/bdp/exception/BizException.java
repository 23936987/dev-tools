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
    private  static  ErrorEnum errorEnum = BizErrorEnum.FAILURE;
    private String errorCode;
    public BizException(){
        super(errorEnum.getErrorMsg());
        this.errorCode = errorEnum.getErrorCode();

    }
    public BizException(String errorMsg){
        super(errorMsg);
        this.errorCode = errorEnum.getErrorCode();
    }
    public BizException(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMsg());
        this.errorCode = errorEnum.getErrorCode();
    }

    public BizException(ErrorEnum errorEnum, String errorMsg) {
        super(errorEnum.getErrorMsg());
        this.errorCode = errorEnum.getErrorCode();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}



