package com.dept.controller;

import com.dept.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author WH1707008
 * @date 2018/7/26 10:56
 * Description:
 */
@RestController
public class HelloController {
    @RequestMapping(value = "hello",produces = "application/json;charset=UTF-8")
    public  String hello(){
        return "hello,世界";
    }

    /**解决中文乱码
     * 1.在@RequestMapping中添加注解（这种方法需要每个注解都要加）
     * produces="application/json;charset=UTF-8"
     *2.修改配置类，请看GlobalDefaultWebMvcConfig.java类(暂时没做出来)
     * @return
     */
    @RequestMapping(value = "hello2",produces = "application/json;charset=UTF-8")
    public String hello2(){
        return "hello,中文";
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
