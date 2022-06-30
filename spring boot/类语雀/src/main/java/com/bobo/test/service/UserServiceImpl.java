package com.bobo.test.service;

import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public Collection<User> queryUserByStatus() {
        return userMapper.queryUserByStatus();
    }

    @Override
    public User queryUserByNum(String num) {
        return userMapper.queryUserByNum(num);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(String user_num,String user_name,String user_email) {
        return userMapper.updateUser(user_num,user_name,user_email);
    }

    @Override
    public int deteleUser(String user_num) {
        return userMapper.deteleUser(user_num);
    }

    @Override
    public int updateUserPassword(String user_num, String user_password) {
        return userMapper.updateUserPassword(user_num,user_password);
    }

}
