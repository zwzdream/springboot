package com.dept.repository;

import com.dept.model.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * @author WH1707008
 * @date 2018/7/26 15:47
 * Description:
 */
public interface CatRepository extends CrudRepository<Cat,Integer> {

}
