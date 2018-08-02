package com.dept.controller;

import com.dept.model.User;
import com.dept.service.IUserServer;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PageHelper.startPage(1, 3);
        List<User> userList = userServer.findUser();
        return userList;
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

    @RequestMapping(value = "/username/listPage")
    public  Map<String, Object> listPage(
            @RequestParam(value="username")String username,
            @RequestParam(value="pageNumber")int pageNumber,
            @RequestParam(value="pageSize")int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<User> userBean = userServer.findByName(username);
        List<User> userBean1 = userServer.findByName(username);
        //return userBean;
        Map<String,Object> map=new HashMap<>(16);
        map.put("rows", userBean);
        map.put("total", userBean1.size());
        return map;

    }




}
