package com.dept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author WH1707008
 * @date 2018/7/27 14:39
 * Description:
 */
@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){
        map.put("hello", "from TemplateController.hello");
        return "hello";
    }

    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello", "from TemplateController.helloFtl");
        return "helloFtl";
    }

}
