package com.dept.config;


import com.dept.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * @author WH1707008
 * @date 2018/7/19 18:47
 * Description:
 *  EnableWebMvc注解开启SpringMVC支持，若无此句，重写方法无效
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.dept")
public class MyMvcConfig extends WebMvcConfigurationSupport {

    //配置 视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return  viewResolver;
    }


    /* 配置静态资源映射，也可以在配置文件配置
     * addResourceLocations指的是文件放置的目录，
     * addResourceHandler指的是对外暴露的访问路径
     * super.addResourceHandlers(registry);这段代码可以不要
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/assets/");
        super.addResourceHandlers(registry);
    }


    /**
     *配置拦截器
     *1.配置自定义拦截器的Bean
     *2.重写addInterceptors方法，注册拦截器
     */
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }



    /**
     * 无任何业务处理，只是简单的页面转向，一般至少需要三行有效代码，在开发中会
     * 涉及大量这样的页面转向，会显得麻烦，可以在配置中重写addViewControllers来
     * 简化配置
     * @param registry
     */


    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        super.addViewControllers(registry);
    }

    /**
     * 重写addViewControllers，需要注解下面的Bean，不然访问会报404错误
     * @return
     */
    @Bean
    @Override
    public HandlerMapping viewControllerHandlerMapping(){
        return super.viewControllerHandlerMapping();
    }
}
