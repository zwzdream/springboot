package com.dept.service.impl;

import com.dept.dao.IPeopleDao;
import com.dept.model.People;
import com.dept.service.IPeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author WH1707008
 * @date 2018/7/27 20:09
 * Description:
 */
@Service
public class PeopleServiceImpl implements IPeopleService {
    @Resource
    private IPeopleDao peopleDao;
    @Override
    public int savePeople(People people) {
        return peopleDao.savePeople(people);
    }
}
