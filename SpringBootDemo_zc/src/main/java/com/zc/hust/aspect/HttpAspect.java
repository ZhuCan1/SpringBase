package com.zc.hust.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //定义切入点
    @Pointcut("execution(public * com.zc.hust.controller.UserController.*(..))")
    public void log(){

    }
    //前置方法
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获得请求url
        logger.info("url={}",request.getRequestURL());
        //获得请求method(get/post)
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法(类全路径+方法名)
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }
    //后置方法
    @After("log()")
    public void doAfter(){
        logger.info("22222222222");
    }

    //获取返回的内容
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturing(Object object) throws Exception{
        logger.info("response={}",object.toString());
    }
}
