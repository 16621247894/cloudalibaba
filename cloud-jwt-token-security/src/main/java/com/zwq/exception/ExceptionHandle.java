package com.zwq.exception;

import com.zwq.message.ReturnMessage;
import com.zwq.message.ReturnMessageUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

//@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    public ReturnMessage<Object> handle(HttpServletResponse response, Exception exception) {
        response.setCharacterEncoding("utf-8");
        System.out.println("获取的exception:"+ exception.getMessage());
        if(exception instanceof JKException) {
            JKException sbexception = (JKException)exception;
            return ReturnMessageUtil.error(sbexception.getCode(), sbexception.getMessage());
        }else {
            return ReturnMessageUtil.error(-1, "未知异常"+exception.getMessage());
        }
    }

}
