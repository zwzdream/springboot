package com.dept;

import com.dept.socket.SocketServer;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author WH1707008
 * @date 2018/8/21 15:41
 * Description:
 */
@SpringBootApplication
public class Application  {
    public static void main(String[] args) {
        /**
         * 将applicationContext设置到MyWebSocket类中，在MyWebSocket中利用这个上下文获得想要的service对象
         */
        SpringApplication application=new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);

    }
}
