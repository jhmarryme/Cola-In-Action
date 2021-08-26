/**
 * 
 */
package com.jhmarryme.cola.security.properties;


/**
 * 系统常量
 * @author Jiahao Wang
 * @date 2020/12/28 12:15
 */
public interface SecurityConstants {
	
	/**
	 * 默认的处理验证码的url前缀
	 */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 当请求需要身份认证时，默认的登录地址, 会映射到具体的html
	 *
	 */
    String DEFAULT_LOGIN_PAGE_URL = "/authorize/login";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authorize/form";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authorize/mobile";
	/**
	 * 默认的基于openId的登录请求处理url
	 */
    String DEFAULT_LOGIN_PROCESSING_URL_REST= "/authorize/rest";
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * openId
	 */
    String DEFAULT_PARAMETER_NAME_OPENID = "openId";
	/**
	 * providerId
	 */
    String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";
	/**
	 * session失效默认的跳转地址
	 */
    String DEFAULT_SESSION_INVALID_URL = "/session/invalid";

}
