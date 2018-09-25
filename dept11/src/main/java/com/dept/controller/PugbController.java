package com.dept.controller;

import com.dept.common.utils.PoolCache;
import com.dept.common.utils.ScanPool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author WH1707008
 * @date 2018/8/29 14:15
 * Description:
 */
@Controller
public class PugbController {
    /**
     * 加载二维码页面
     * @return
     */
    @RequestMapping("/pugb")
    public ModelAndView pugb(){
        String uuid= UUID.randomUUID().toString();
        PoolCache.cacheMap.put(uuid, new ScanPool());
        ModelAndView modelAndView=new ModelAndView("pugb");
        modelAndView.addObject("uuid", uuid);
        return modelAndView;
    }

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request){
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println(parameterNames.toString());


        return "welcome";
    }


    @RequestMapping(value = "/index",produces = "application/json;charset=utf-8")
    public @ResponseBody String index(){
        return "index中文";
    }
}
