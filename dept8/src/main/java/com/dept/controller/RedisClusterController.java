package com.dept.controller;

import com.dept.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WH1707008
 * @date 2018/8/2 13:31
 * Description:
 */
@RestController
public class RedisClusterController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "getRedis",produces="application/json;charset=utf-8")
    public String getRedis(){
         return   redisService.findRedis();
    }



}
