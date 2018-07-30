package com.dept.service.impl;

import com.dept.dao.IUserDao;
import com.dept.model.User;
import com.dept.service.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/27 17:48
 * Description:
 */
@Service
public class UserServerimpl implements IUserServer {
    /**
     * @resource如果配置了name，则先name注入 如果没有配置name值，则以变量名注入
     * @autowired是以类名注入的方式，而mybatis中是基于接口的dao，没有具体的实现类
     * @resource dao对象（不会报错）
     * @autowired dao对象（出错，但是可以运行）
     * 整合spring+mybatis注入dao对象时，最好使用@resource(name='xxxDao')的方式
     */
    @Resource
    private IUserDao userDao;

    @Override
    public List<User> findUser() {
        return userDao.findUser();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUser(User user) throws Exception{
        int i = 0;
        try {
            System.out.println("这里是一个事务");
            i = userDao.saveUser(user);
           int b= i/0;
        } catch (Exception e) {
            //throw e;
            throw new Exception();
        }


        return i;
    }
}
