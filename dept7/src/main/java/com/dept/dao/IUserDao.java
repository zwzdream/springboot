package com.dept.dao;

import com.dept.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author WH1707008
 * @date 2018/7/27 17:43
 * Description:@Mapper让接口可以被扫描到，然后在spring容器里创建一个bean
 * 如果没有注解会业务逻辑层注入IUserDao的bean，会报错找不到bean
 * 当然如果接口多了，嫌一个个注解麻烦，可在启动类上面注解@MapperScan("com.dept.dao")
 *
 */
@Mapper
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
     List<User> findUser();

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
     User findById(int id);

    /**
     * 根据name查找用户
     * @param name
     * @return
     */
     List<User> findByName(String name);

    /**
     * 保存用户（id，name）
     * @param user
     * @return
     */
     int saveUser(User user);
}
