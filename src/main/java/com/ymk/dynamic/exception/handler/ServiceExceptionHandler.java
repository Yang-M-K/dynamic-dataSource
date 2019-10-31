package com.ymk.dynamic.exception.handler;


import com.ymk.dynamic.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ServiceExceptionHandler extends AbstractExceptionHandler{

    @ExceptionHandler(value = ServiceException.class)
    public String serviceException(ServiceException e, HttpServletRequest request){
        super.error(e,e.getMessage(),request);
        return "serviceException捕捉异常：请求路径："+request.getRequestURI()+"异常信息："+e.getMessage();
    }


}
