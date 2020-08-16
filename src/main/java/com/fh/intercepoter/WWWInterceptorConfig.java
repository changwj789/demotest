package com.fh.intercepoter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器的配置   拦截那些东西  不拦截那些东西
@Configuration//声明是配置文件类
public class WWWInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new WWWintercepoter());
        registration.addPathPatterns("/**");//代表拦截所有
    }
}
