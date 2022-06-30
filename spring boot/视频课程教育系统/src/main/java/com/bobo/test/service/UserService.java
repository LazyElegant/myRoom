package com.bobo.test.service;

import com.bobo.test.pojo.User;

public interface UserService{

    public User queryUserByNum(Long username);

    public User queryUserByEmail(String email);

    public int addUser(User user);

    public int updateUser(Long user_num,String user_name,String user_email);

    public int deteleUser(String user_num);
}
