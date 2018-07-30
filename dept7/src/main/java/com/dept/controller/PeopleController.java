package com.dept.controller;

import com.dept.model.People;
import com.dept.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WH1707008
 * @date 2018/7/27 20:03
 * Description:
 */
@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private IPeopleService peopleService;

    /**
     * http://localhost:8080/people/savePeople2?id=${id}&name=${name}
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/savePeople")
    public int savePeople(@RequestParam(value = "id") int id, @RequestParam("name") String name){
        People people=new People();
        people.setId(id);
        people.setName(name);
     return peopleService.savePeople(people);
    }

    /**
     * http://localhost:8080/people/savePeople2?id=${id}&name=${name}
     *使用Client REST发送post请求,参看restPost.png图片的显示
     * @param people
     * @return
     */
    @RequestMapping("/savePeople2")
    public int savePeople2(@RequestBody  People people){
        return peopleService.savePeople(people);
    }
}
