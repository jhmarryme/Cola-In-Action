package com.jhmarryme.cola.security.browser;

import com.jhmarryme.cola.security.authentication.AbstractSecurityConfig;
import com.jhmarryme.cola.security.properties.SecurityProperties;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.util.Map;

/**
 * springSecurity 配置
 * @author JiaHao Wang
 * @date 2020/10/29 12:23
 */
@Configuration
@EnableWebSecurity(debug = true)
public class BrowserSecurityConfig extends AbstractSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    // @Autowired
    // private UserDetailsPasswordService userDetailsPasswordService;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 开启表单登录相关配置
        // applyFormAuthenticationConfig(http);

        applyRestAuthenticationConfig(http);

        applyValidateCodeConfig(http);

        applySmsAuthenticationConfig(http);
        http
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService) // 配置 AuthenticationManager 使用 userService
                .passwordEncoder(passwordEncoder()) // 配置 AuthenticationManager 使用 userService
        // .userDetailsPasswordManager(userDetailsPasswordService)// 配置密码自动升级服务
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 默认编码算法的 Id
        val idForEncode = "bcrypt";
        // 要支持的多种编码器
        val encoders = Map.of(
                idForEncode, new BCryptPasswordEncoder(),
                "SHA-1", new MessageDigestPasswordEncoder("SHA-1")
        );
        return new DelegatingPasswordEncoder(idForEncode, encoders);
    }

}
