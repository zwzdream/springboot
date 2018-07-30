package com.dept.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WH1707008
 * @date 2018/7/19 19:29
 * Description:拦截器（Interceptor）实现对每一个请求处理前后进行相关的业务处理，
 * 类似于Servlet的Filter
 * 继承HandlerInterceptorAdapter类或实现HandlerInterceptor接口可以实现自定义拦截器
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
    /**在请求发生前执行*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }
    /**在请求完成后执行*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime=(Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime=System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+new Long(endTime-startTime)+"ms");
        request.setAttribute("handlingTime", endTime-startTime);
    }
}
