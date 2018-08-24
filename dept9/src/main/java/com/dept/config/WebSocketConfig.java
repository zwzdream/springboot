package com.dept.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author WH1707008
 * @date 2018/8/20 17:07
 * Description:  这里演示广播式，即服务器有消息时，会将消息发送给所有连接了当前endpoint的浏览器
 *
 * 一.配置WebSocket
 * 1.使用@EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理(message broker)的消息，
 * 这时控制器支持使用MessageMapping，就像使用RequestMapping一样
 * 2，注册STOMP协议的节点（endpoint），并映射指定的URL
 * 3，注册一个STOMP的endpoint，并指定使用SockJS协议
 * 4，配置消息代理(Message Broker)
 * 5，广播式应配置一个/topic消息代理
 */
@Configuration
@EnableWebSocketMessageBroker//1
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//2
        //3
        registry.addEndpoint("/endpointWisely").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//4
        //5
        registry.enableSimpleBroker("/topic");

    }
}
