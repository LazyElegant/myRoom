package com.bobo.test.mapper;

import com.bobo.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface UserMapper {

    public User queryUserByNum(String username);

    public Collection<User> queryUserByStatus();

    public int addUser(User user);

    public int updateUser(String user_num,String user_name,String user_email);

    public int deteleUser(String user_num);

    public int updateUserPassword(String user_num,String user_password);
}
