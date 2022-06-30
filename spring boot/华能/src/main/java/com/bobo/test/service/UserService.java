package com.bobo.test.service;

import com.bobo.test.dto.LoginDTO;
import com.bobo.test.dto.RegisterDTO;
import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2021/9/4 16:22
 */
@Service
public class UserService {

    @Resource
    private UserMapper mapper;

    public User login(LoginDTO dto){
        String password = mapper.login(dto.getId());
        if(dto.getPassword().equals(password)){
            return mapper.getUser(dto.getId());
        }else {
            return null;
        }
    }

    public boolean register(RegisterDTO dto){
        dto.setCreatTime(LocalDateTime.now());
        return mapper.register(dto) > 0;
    }
}
