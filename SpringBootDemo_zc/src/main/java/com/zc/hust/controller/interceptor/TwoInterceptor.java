package com.zc.hust.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwoInterceptor implements HandlerInterceptor {

    //在请求处理执行之前进行调用(controller方法调用之前)
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("被two拦截,放行....");
        return true;
    }

    //请求处理之后进行调用，但是在视图被渲染之前(controller方法调用之后)
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //在整个请求结束后被调用,在就是视图渲染之后被调用(主要用于进行资源清理工作)
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
