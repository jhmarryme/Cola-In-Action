package com.jhmarryme.cola.security.browser;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/17 18:02
 */
public enum BrowserErrorEnum {
    /** 参数校验错误 */
    NEED_AUTHENTICATION("NEED_AUTHENTICATION", "访问的服务需要身份认证，请引导用户到登录页"),
    /** 未知异常 */
    SESSION_INVALID("SESSION_INVALID", "未知异常"),
    LOGIN_FAILED("LOGIN_FAILED", "登录失败"),

    ;

    BrowserErrorEnum(String errorCode, String errorMsg) {
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
