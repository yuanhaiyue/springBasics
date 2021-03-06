package com.yuan.demo;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.BindException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConstraintViolationException(HttpServletResponse response,ConstraintViolationException constraintViolationException) throws IOException {
        System.out.println("jxx1");
        String msg =constraintViolationException.getMessage();
        String [] msgs=msg.split(":");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(msgs[msgs.length-1]);
    }

    @ExceptionHandler(BindException.class)
    public void handleBindException(HttpServletResponse response,BindException ex)throws IOException{
        System.out.println("jxx2");
        String result=ex.getMessage();
        String[] msgs=result.split(":");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(msgs[msgs.length-1]);
    }

}
