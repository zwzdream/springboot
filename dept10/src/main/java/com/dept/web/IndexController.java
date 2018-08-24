package com.dept.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WH1707008
 * @date 2018/8/21 15:39
 * Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
            return "index";
    }
}
