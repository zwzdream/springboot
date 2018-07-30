package com.dept.service;

import com.dept.dao.CatDao;
import com.dept.model.Cat;
import com.dept.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/26 15:49
 * Description:
 */
@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;
    @Resource
    private CatDao catDao;

    /**
     * save,update,delete方法需要绑定事务
     * 使用@Transactional进行事务的绑定
     */
    //保存数据
    @Transactional
    public void save( Cat cat){
        catRepository.save(cat);
    }

    //删除数据
    @Transactional
    public void delete(int id){
        catRepository.deleteById(id);
    }

    //查询数据.
    public Iterable<Cat> getAll(){
        return catRepository.findAll();
    }
    public Cat selectByCatName(String catName){
        return catDao.selectByCatName(catName);
    }


}
