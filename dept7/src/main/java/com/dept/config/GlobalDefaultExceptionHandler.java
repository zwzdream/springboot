package com.dept.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WH1707008
 * @date 2018/7/27 12:13
 * Description:
 *
 * 1.新建一个Class，这里取名GlobalDefaultExceptionHandler
 * 2.在Class上添加注解，@ControllerAdvice,这个注解声明一个
 * 控制器建言，@ControllerAdvice组合了@Component注解，所以自动注册为Spring的bean
 * 3.在class中添加一个方法,取名defaultExceptionHandler
 * 4.在方法上添加@ExceptionHandler定义全局处理，通过@ExceptionHandler的value属性可过滤拦截
 * 的条件，在此处拦截所有的Exception
 * 5.如果返回的是View--方法的返回值是ModelAndView
 * 如果返回的是String或者是Json数据，那么需要在方法上添加@ResponseBody注解
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request,Exception e){
        //返回String
        return "对不起，服务器繁忙，请稍后再试！";
    }
}
