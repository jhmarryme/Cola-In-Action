package com.jhmarryme.cola.config.i18n;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * 国际化配置, 默认语言为中文, 配置为请求拦截, 并将客户端的 Locale 保存到 HttpSession
 * <p>通过cola.i18n.interceptor=request 开启</p>
 * @author Jiahao Wang
 * @date 2021/3/5 11:22
 */
@Configuration
@ConditionalOnProperty(prefix = "cola.i18n", name = {"interceptor", "enable"}, havingValue = "true")
public class WebConfig implements WebMvcConfigurer {

    /**
     * 拦截请求中 key 为 lang 的参数（不配置的话是 locale），这个参数则指定了当前的环境信息。
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        // 根据请求头中的lang区别, zh-TW/zh-CH/en-US
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    /**
     * 替换掉默认的 AcceptHeaderLocaleResolver
     *      不同于 AcceptHeaderLocaleResolver 通过请求头来判断当前的环境信息，
     *      SessionLocaleResolver 将客户端的 Locale 保存到 HttpSession对象中，并且可以进行修改
     *     （这意味着当前环境信息，前端给浏览器发送一次即可记住，只要 session 有效，浏览器就不必再次告诉服务端当前的环境信息）。
     * @return org.springframework.web.servlet.LocaleResolver
     */
    @Bean
    LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // 默认为中文
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return localeResolver;
    }

}
