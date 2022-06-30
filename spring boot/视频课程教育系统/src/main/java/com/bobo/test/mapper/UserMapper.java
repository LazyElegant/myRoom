package com.bobo.test.mapper;

import com.bobo.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    public User queryUserByNum(Long id);

    public User queryUserByEmail(String email);

    public int addUser(User user);

    public int updateUser(Long id,String name,String email);

    public int deteleUser(String id);

}
