package com.dept.service;

import com.dept.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/7/27 17:48
 * Description:
 */
public interface IUserServer {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findUser();

    /**
     * 根据ID查找用户
     * @return
     */
    User findById(int id);

    /**
     * 根据name查找用户
     * @return
     */
    List<User> findByName(String name);

    /**
     * 保存用户（id，name）
     * @param user
     * @return
     */
    int saveUser(User user) throws Exception;
}
