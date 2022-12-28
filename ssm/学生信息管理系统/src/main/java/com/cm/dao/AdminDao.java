package com.cm.dao;

import com.cm.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @Author admin
 * @create 2022/5/23 22:00
 */
public interface AdminDao {
    int insert(Admin admin);
    Admin get(@Param("name") String name,@Param("password") String password);
}
