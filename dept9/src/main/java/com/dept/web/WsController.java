package com.dept.web;

import com.dept.domain.WiselyMessage;
import com.dept.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author WH1707008
 * @date 2018/8/20 17:22
 * Description:
 * 四，演示控制器
 * 1,当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMapping
 * 2，当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception{
        Thread.sleep(3000);
        return new WiselyResponse("Welcome,"+message.getName()+"!");
    }
}
