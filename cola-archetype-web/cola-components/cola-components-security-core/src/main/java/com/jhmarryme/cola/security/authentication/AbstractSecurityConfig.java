package com.jhmarryme.cola.security.authentication;

import com.jhmarryme.cola.security.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.jhmarryme.cola.security.authentication.rest.RestAuthenticationFilter;
import com.jhmarryme.cola.security.properties.SecurityConstants;
import com.jhmarryme.cola.security.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * security的相关配置
 * @author JiaHao Wang
 * @date 2021/1/12 12:44
 */
public class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler colaAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler colaAuthenticationFailureHandler;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;


    protected void applyFormAuthenticationConfig(HttpSecurity http) throws Exception {
        http
            .formLogin(login -> login
                    .loginPage(SecurityConstants.DEFAULT_LOGIN_PAGE_URL)
                    .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/")
                       .failureHandler(colaAuthenticationFailureHandler)
                       .successHandler(colaAuthenticationSuccessHandler)
                    .permitAll())
        ;
    }

    protected void applyRestAuthenticationConfig(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> authorizeRequests
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/api/**").hasRole("USER")
                    .antMatchers("/authorize/**").permitAll())
            .addFilterAt(restAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            // .csrf(AbstractHttpConfigurer::disable)
            // .formLogin(AbstractHttpConfigurer::disable)
            // .httpBasic(AbstractHttpConfigurer::disable)
        ;
    }
    protected void applyValidateCodeConfig(HttpSecurity http) throws Exception {
        http
            .apply(validateCodeSecurityConfig)
                .and()
            .authorizeRequests(authorizeRequests -> authorizeRequests
                    .antMatchers(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*")
                    .permitAll()
            )
        ;
    }

    protected void applySmsAuthenticationConfig(HttpSecurity http) throws Exception {
        http
            .apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .authorizeRequests(authorizeRequests -> authorizeRequests
                    .antMatchers(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE)
                    .permitAll()
            )
        ;
    }

    protected void applyStatelessAuthenticationConfig(HttpSecurity http) throws Exception {
        http
            .requestMatchers(req -> req.mvcMatchers("/api/**", "/admin/**", "/authorize/**"))
            .sessionManagement(sessionManagement -> sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        ;
    }

    private RestAuthenticationFilter restAuthenticationFilter() throws Exception {
        RestAuthenticationFilter filter = new RestAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(colaAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(colaAuthenticationFailureHandler);
        filter.setAuthenticationManager(authenticationManager());
        filter.setFilterProcessesUrl("/authorize/login");
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
