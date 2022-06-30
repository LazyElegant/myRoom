package com.bobo.test.mapper;

import com.bobo.test.dto.RegisterDTO;
import com.bobo.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author admin
 * @create 2021/9/4 16:24
 */
@Repository
@Mapper
public interface UserMapper {

    public String login(Long id);

    public User getUser(Long id);

    public int register(RegisterDTO dto);
}
