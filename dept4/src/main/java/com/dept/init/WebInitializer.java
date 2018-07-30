package com.dept.init;

import com.dept.config.MyMvcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author WH1707008
 * @date 2018/7/19 17:20
 * Description:
 * 1.WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口，
 * 从而实现了替换web.xml的位置。实现此接口将会自动被SpringServletContainerInitializer
 * (用来启动Servlet3.0容器)获取到。
 * 2.新建WebApplicationContext，注册配置类，并将其和当前ServletContext关联。
 * 3.注册SpringMVC的DispatcherServlet
 */

public class WebInitializer implements WebApplicationInitializer {//1
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();

        ctx.register(MyMvcConfig.class);
        //2
        ctx.setServletContext(servletContext);
        //3
        Dynamic servlet=servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


    }
}
