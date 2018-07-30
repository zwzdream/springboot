package com.dept.dao;

import com.dept.model.People;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WH1707008
 * @date 2018/7/27 20:03
 * Description:
 */
@Mapper
public interface IPeopleDao {
    /**save
     * @param people
     * @return
     */
    int savePeople(People people);
}
