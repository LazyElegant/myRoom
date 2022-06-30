package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.dto.LoginDto;
import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean Login(LoginDto dto){
        User user = userMapper.getUserById(dto.getId());
        if (user != null && user.getPassword().equals(dto.getPassword())){
            Tool.setUSER(user);
            return true;
        }else {
            return false;
        }
    }

    public boolean registration(User user) {

        if (userMapper.getUserById(user.getId()) != null){
            return false;
        }else {
            user.setRegistrationTime(LocalDateTime.now());
            userMapper.registration(user);
            return true;
        }
    }

    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    public int update(User user){
        return userMapper.update(user);
    }

    public List<User> listUser(){
        return userMapper.listUser();
    }
}
