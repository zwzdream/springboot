package com.dept.dao;

import com.dept.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/27 10:58
 * Description:@Repository注解，标注这是一个持久化对象
 */
@Repository
public class CatDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 1.定义一个sql语句
     * 2.定义一个RowMapper
     * 3.执行查询方法
     * @return
     */
    public Cat selectByCatName(String catName){
        String sql="select * from cat where cat_name=?";
        RowMapper<Cat> rowMapper=new BeanPropertyRowMapper<>(Cat.class);
        Cat cat=jdbcTemplate.queryForObject(sql, new Object[]{catName}, rowMapper);
        return cat;
    }


    /**
     * 1.定义一个sql语句
     * 2.定义一个RowMapper
     * 3.执行查询方法
     * @return
     */
    public List<Cat> selectLikeCatName(String catName){
        String sql="select * from cat where cat_name = ?";
        RowMapper<Cat> rowMapper=new BeanPropertyRowMapper<>(Cat.class);
        List catList = jdbcTemplate.queryForList(sql,new Object[]{catName},rowMapper);
        return catList;
    }
}
