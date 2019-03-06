package com.zc.hust.controller;

import com.zc.hust.pojo.IMoocJSONResult;
import javax.servlet.http.HttpServletRequest;
//@RestControllerAdvice
//@ControllerAdvice
public class IMoocAjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    //@ResponseBody
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }
}
