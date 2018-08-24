package com.dept.domain;

/**
 * @author WH1707008
 * @date 2018/8/20 17:20
 * Description:
 * 三，服务器向浏览器发送的此类的消息
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
