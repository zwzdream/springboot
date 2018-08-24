package com.dept.socket;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WH1707008
 * @date 2018/8/21 14:07
 * Description:
 * 1.每个浏览器代表一个用户，与服务端建立连接后，实现服务端与浏览器的交互
 * 2.暴露websocket推送接口，其他服务端或者业务类调用该接口，向
 * 指定用户进行消息推送
 */

@ServerEndpoint("/socketServer")
@Component
public class SocketServer {
    /**
     * 浏览器与服务端的回话，浏览器每new一个WebSocket就创建一个Session，
     * 关闭或刷新浏览器，session关闭
     */
    private Session session;
    /**
     * 代表浏览器
     */
    private String userid;

    /**
     * 推送消息接口，可以供外部调用
     * @param sendMsg
     * @throws IOException
     */
    public void sendMsg(String sendMsg) throws IOException {
        System.out.println(this.session+";"+this.userid+";"+sendMsg);
        this.session.getBasicRemote().sendText(sendMsg);
    }

    /**
     * 设置Map，存放每个用户的连接
     */
    public static Map<String,SocketServer> webSocketSet=new HashMap<>();

    @OnOpen
    public void onOpen(Session session) throws  IOException{
        this.session=session;
        System.out.println(this+"有新连接,session="+session+";userid="+userid);
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this.userid);
        System.out.println(this+";连接关闭");
    }

    @OnMessage
    public void onMessage(String info) throws IOException{
        System.out.println(this+";来自客户端的消息:"+info);
        String msg="服务端接收到了来自客户端的消息:"+info;
        if(info.contains("userid")){
            this.userid=info.split("userid=")[1];
            System.out.println(this+",this.session="+this.session+";this.userid="+this.userid);
            webSocketSet.put(userid, this);
        }
    }

    @OnError
    public void onError(Throwable error){
        System.out.println(this+";发生错误");
        error.printStackTrace();
    }
}
