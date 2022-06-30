package com.bobo.test.mapper;

import com.bobo.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int registration(User user);

    User getUserById(Integer id);

    int update(User user);

    List<User> listUser();
}
