package com.dept.service.impl;

import com.dept.dao.IUserDao;
import com.dept.model.User;
import com.dept.service.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisCluster;

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

    /**
     * 测试缓存
     * @return
     */

    @Override
    @Cacheable(value="findUser")
    public List<User> findUser() {
        System.out.println("无缓存的时候调用这里");
        return userDao.findUser();
    }

    /**
     * 在对应的mapperxml文件，开启二级缓存，
     * Cache Hit Ratio表示缓存命中率。开启二级缓存后，每执行一次查询，系统都会计算一次二级缓存的命中率。第一次查询也是先从缓存中查询，只不过缓存中一定是没有的。
     * 所以会再从DB中查询。由于二级缓存中不存在该数据，所以命中率为0.但第二次查询是从二级缓存中读取的，所以这一次的命中率为1/2=0.5。
     * 当然，若有第三次查询，则命中率为1/3=0.66
     * @param id
     * @return
     */
    @Override
    public User findById(int id) {
       User user=  userDao.findById(id);
        System.out.println(user);
       User user2=  userDao.findById(id);
        System.out.println(user2);
       return user;
    }

    @Override
    @Cacheable(value = "findByName")
    public List<User> findByName(String name) {
        System.out.println("无缓存的时候调用这里");
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
