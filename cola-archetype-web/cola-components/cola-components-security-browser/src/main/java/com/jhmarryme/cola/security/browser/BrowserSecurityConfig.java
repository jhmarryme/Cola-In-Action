package com.jhmarryme.cola.security.browser;

import com.jhmarryme.cola.security.authentication.AbstractChannelSecurityConfig;
import com.jhmarryme.cola.security.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.jhmarryme.cola.security.properties.SecurityConstants;
import com.jhmarryme.cola.security.properties.SecurityProperties;
import com.jhmarryme.cola.security.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * springSecurity 配置
 * @author JiaHao Wang
 * @date 2020/10/29 12:23
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 开启表单登录相关配置
        applyPasswordAuthenticationConfig(http);

        http
                .apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                // 最大session时, 组织后续用户登录
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
                .logout()
                .logoutUrl("/signOut")
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .and()
                .authorizeRequests()
                // 不需要登录的路径
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATED_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getLoginPage(),
                        securityProperties.getBrowser().getSignUpUrl(),
//                        securityProperties.getBrowser().getSignOutUrl(),
                        securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html",
                        // 该路径由于只有业务系统知道, 还需进一步抽取
                        "/user/register"
                ).permitAll()
                // 其他所有请求都需要认证
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
