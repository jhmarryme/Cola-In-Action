package com.jhmarryme.cola.exception;

/**
 * Base Exception is the parent of all exceptions
 *
 * @author fulan.zjf 2017年10月22日 上午12:00:39
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /** 错误码 由系统定义 */
    private String errCode;

    /**
     * 参数用来补充说明异常消息，如需提示用户在某IP处登录可以设置消息
     * <p>指定errorCode时才能设置
     */
    private String[] params;

    public BaseException(String errMessage) {
        super(errMessage);
    }

    public BaseException(String errCode, String errMessage, String... params) {
        super(errMessage);
        this.errCode = errCode;
        this.params = params;
    }

    public BaseException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public BaseException(String errCode, String errMessage, Throwable e, String... params) {
        super(errMessage, e);
        this.errCode = errCode;
        this.params = params;
    }


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String[] getParams() {
        return params;
    }
}
