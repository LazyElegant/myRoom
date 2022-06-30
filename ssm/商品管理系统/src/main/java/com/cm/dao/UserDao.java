package com.cm.dao;

import com.cm.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author admin
 * @create 2022/5/23 22:00
 */
public interface UserDao {

    /**
     * 添加user
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 获得user
     * @param name
     * @param password
     * @return
     */
    User get(@Param("name") String name,@Param("password") String password);

    /**
     * 修改user
     * @param id
     * @param password
     * @return
     */
    int update(@Param("id") Integer id,@Param("password") String password);
}
