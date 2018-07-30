package com.dept.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author WH1707008
 * @date 2018/7/19 15:47
 * Description:
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.dept")
public class MyMvcConfig {
    /**
     * 配置 视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        /* 开发时的目录
         *  viewResolver.setPrefix("/WEB-INF/views/");
         */
        //运行时的目录结构
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return  viewResolver;
    }
}
