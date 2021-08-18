package com.jhmarryme.cola.config.exception;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/17 18:02
 */
public enum CatchLogErrorEnum {
    /** 参数校验错误 */
    PARAM_VERIFICATION_ERROR("PARAM_VERIFICATION_ERROR", "参数校验错误"),
    /** 未知异常 */
    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知异常")
    ;

    CatchLogErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /** 错误码 */
    private final String errorCode;

    /** 错误消息 */
    private final String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
