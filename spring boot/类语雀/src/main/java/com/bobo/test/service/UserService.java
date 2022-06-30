package com.bobo.test.service;

import com.bobo.test.pojo.User;

import java.util.Collection;

public interface UserService{

    public Collection<User> queryUserByStatus();

    public User queryUserByNum(String username);

    public int addUser(User user);

    public int updateUser(String user_num,String user_name,String user_email);

    public int deteleUser(String user_num);

    public int updateUserPassword(String user_num,String user_password);
}
