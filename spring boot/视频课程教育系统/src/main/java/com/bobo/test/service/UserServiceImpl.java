package com.bobo.test.service;

import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;


    @Override
    public User queryUserByNum(Long num) {
        return userMapper.queryUserByNum(num);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }


    @Override
    public int updateUser(Long user_num,String user_name,String user_email) {
        return userMapper.updateUser(user_num,user_name,user_email);
    }

    @Override
    public int deteleUser(String user_num) {
        return userMapper.deteleUser(user_num);
    }


}
