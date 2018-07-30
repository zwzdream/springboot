package com.dpet.controller;

import com.dpet.model.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WH1707008
 * @date 2018/7/20 15:05
 * Description:
 */
@RestController
public class HelloController {
    private  static final String TEMPLATE="Hello,%s!";

    @RequestMapping("/user")
    public HttpEntity<Greeting> user(
            @RequestParam(value = "name",required = false,defaultValue = "World") String name){
            Greeting greeting=new Greeting(String.format(TEMPLATE,name));
            return new ResponseEntity<>(greeting,HttpStatus.OK);


    }
}
