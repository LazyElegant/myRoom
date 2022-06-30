package com.bobo.test.service;

import com.bobo.test.pojo.User;

import java.util.Collection;

public interface UserService{

    public User queryUserByNum(int username);

    public int addUser(User user);

    public int updateUser(int user_num,String user_name,String user_email);

    public int deteleUser(String user_num);
}
