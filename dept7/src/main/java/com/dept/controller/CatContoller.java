package com.dept.controller;

import com.dept.model.Cat;
import com.dept.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/26 15:56
 * Description:
 */
@RestController
@RequestMapping("cat")
public class CatContoller {
    @Autowired
    private CatService catService;

    @RequestMapping("/save")
    public String save(){
        Cat cat=new Cat();
        cat.setCatName("jack");
        cat.setCatAge(3);
        catService.save(cat);
        return "Save Ok";
    }

    @RequestMapping("delete")
    public String delete(){
        catService.delete(1);
        return "delete OK";
    }

    @RequestMapping("getAll")
    public Iterable<Cat> getAll(){
        return catService.getAll();
    }


    @RequestMapping("selectByCatName")
    public Cat selectByCatName(String catName){
        return catService.selectByCatName(catName);
    }



}
