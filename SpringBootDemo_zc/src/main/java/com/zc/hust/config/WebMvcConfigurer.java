package com.zc.hust.config;

import com.zc.hust.controller.interceptor.OneInterceptor;
import com.zc.hust.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器按顺序执行
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");///one/**表示拦截的one/URL路径,/*/*8表示拦截所有URL
        //拦截多个路径
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                                                      .addPathPatterns("/one/**");///one/**
        super.addInterceptors(registry);
    }
}
