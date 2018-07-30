package com.dept.controller;

import com.dept.model.People;
import com.dept.model.User;
import com.dept.service.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/27 17:59
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserServer userServer;

    @RequestMapping("/findUser")
    public List<User> findUser(){
      return  userServer.findUser();
    }

    @RequestMapping("/findById")
    public User findById(int id){
        return  userServer.findById(id);
    }

    @RequestMapping("/findByName")
    public List<User> findByName(String name){
        return  userServer.findByName(name);
    }

  @RequestMapping("/saveUser")
    public int savePeople(User user) throws Exception{
        return  userServer.saveUser(user);
    }



}
