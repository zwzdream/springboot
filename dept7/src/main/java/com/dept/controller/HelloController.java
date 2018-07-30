package com.dept.controller;

import com.dept.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author WH1707008
 * @date 2018/7/26 10:56
 * Description:
 */
@RestController
public class HelloController {
    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "hello2")
    public String hello2(){
        return "hello2";
    }


    @RequestMapping("getUser")
    public User getUser(){
        User user=new User();
        user.setAge(10);
        user.setName("张三");
        user.setCreateDate(new Date());
        user.setRemarks("2018-07-26 11:10创建");
        return user;

    }
}
