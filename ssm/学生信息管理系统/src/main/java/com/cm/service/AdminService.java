package com.cm.service;

import com.cm.dao.AdminDao;
import com.cm.model.Admin;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author admin
 * @create 2022/5/23 22:03
 */
@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDao dao;

    public int insert(Admin admin){
        admin.setId(Tool.getID());
        return dao.insert(admin);
    }

    public Boolean login(String name,String password){
        return dao.get(name, password) != null;
    }
}
