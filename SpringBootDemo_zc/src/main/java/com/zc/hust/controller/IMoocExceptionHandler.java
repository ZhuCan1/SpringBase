package com.zc.hust.controller;

import com.zc.hust.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class IMoocExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,
                               Exception e)throws Exception{
        e.printStackTrace();
        if (isAjax(request)){
            System.out.println("ajax请求");
            return IMoocJSONResult.errorException(e.getMessage());
        }else {
            System.out.println("普通请求");
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }

    }


    /***
     * 判断是普通请求还是ajax请求
     *
     * ***/
    public static boolean isAjax(HttpServletRequest request){
        return request.getHeader("x-requested-with") != null &&
                "XMLHttpRequest".equals(request.getHeader("x-requested-with").toString());

    }
}
