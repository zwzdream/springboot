package com.dept.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/30 12:03
 * Description:
 *   编写一个类继承WebMvcConfigurationSupport后，需要自己配置，springboot自动配置不会生效
 *   　如：自动配置的静态资源路径（classpath:/META/resources/，classpath:/resources/，classpath:/static/，classpath:/public/）不生效
 *   这是因为在 springboot的web自动配置类 WebMvcAutoConfiguration 上有条件注解@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
 *
 *   如果想要使用自动配置生效，又要按自己的需要重写某些方法，比如增加 viewController ，则可以自己的配置类可以继承  WebMvcConfigurerAdapter 这个类。
 *   不过在spring5.0版本后这个类被丢弃了 WebMvcConfigurerAdapter  ，虽然还可以用，但是看起来不好，因为
 *   spring 5.0后要使用Java8，而在Java8中接口是可以有default方法的，所以这个类就没必要了。所以我们只需要在自定义配置类中直接实现
 *
 *       如这个类可以直接写：GlobalDefaultWebMvcConfig implements  WebMvcConfigurer
 */
@Configuration
@EnableWebMvc
public class GlobalDefaultWebMvcConfig extends WebMvcConfigurationSupport {

    /**
     *重写addViewControllers方法，需要注入viewControllerHandlerMapping的对象，不然访问会报404错误
     * addViewControllers，快速定义只需要返回视图（没有任何逻辑）的控制器
     * @return
     */

     @Bean
     @Override
    public HandlerMapping viewControllerHandlerMapping() {
        return super.viewControllerHandlerMapping();
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/bootstrap").setViewName("/bootstrap");
        registry.addViewController("/hello123").setViewName("/hello");
        super.addViewControllers(registry);
    }


    /**
     *重写addResourceHandlers方法，需要注入resourceHandlerMapping的对象，不然访问会报404错
     * @return
     */
    @Bean
    @Override
    public HandlerMapping resourceHandlerMapping() {
        return super.resourceHandlerMapping();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }




}
