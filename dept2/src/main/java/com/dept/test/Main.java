package com.dept.test;

import com.dept.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author WH1707008
 * @date 2018/7/19 13:55
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        /**
         * SpringConfig作为配置类，启动时，会自动创建一个自身bean（springConfig）
         */
        SpringConfig springConfig=context.getBean(SpringConfig.class);
        springConfig.outputResource();
        context.close();

    }
}
