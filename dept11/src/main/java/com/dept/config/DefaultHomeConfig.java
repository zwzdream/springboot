package com.dept.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author WH1707008
 * @date 2018/8/30 11:39
 * Description:
 */
@Configuration
public class DefaultHomeConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/welcome");
        super.addViewControllers(registry);
    }
}
