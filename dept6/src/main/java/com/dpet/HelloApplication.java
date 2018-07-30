package com.dpet;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WH1707008
 * @date 2018/7/20 14:59
 * Description:
 */
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {


       // SpringApplication.run(HelloApplication.class,args);

        //关闭banner
        SpringApplication app=new SpringApplication(HelloApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);


    }
}
