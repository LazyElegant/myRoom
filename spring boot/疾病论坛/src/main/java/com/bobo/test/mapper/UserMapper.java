package com.bobo.test.mapper;

import com.bobo.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface UserMapper {

    public User queryUserByNum(int id);

    public int addUser(User user);

    public int updateUser(int id,String username,String email);

    public int deteleUser(String id);

}
