package com.dept;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author WH1707008
 * @date 2018/8/2 13:42
 * Description:  spring boot不连接数据库启动
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class} )
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
