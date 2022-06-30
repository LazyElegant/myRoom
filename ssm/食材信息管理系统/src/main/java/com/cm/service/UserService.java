package com.cm.service;

import com.cm.dao.UserDao;
import com.cm.model.User;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public int insert(User user){
        user.setId(Tool.getID());
        return dao.insert(user);
    }

    public int update(String password){
        return dao.update(Tool.getUserID(),password);
    }

    public User login(String name,String password){
        return dao.get(name, password);
    }
}
