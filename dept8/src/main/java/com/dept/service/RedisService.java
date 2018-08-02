package com.dept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @author WH1707008
 * @date 2018/8/2 13:35
 * Description:
 */
@Service
public class RedisService {
    @Autowired
    private JedisCluster jedisCluster;


    /**
     * 测试jedisCluster的setter/getter
     * @return
     */
    public String findRedis(){
        jedisCluster.set("username", "张无忌");
        String value= jedisCluster.get("username");
        return value;
    }

}
