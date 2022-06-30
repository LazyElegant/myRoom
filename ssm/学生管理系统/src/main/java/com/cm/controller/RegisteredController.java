package com.cm.controller;

import com.cm.model.Admin;
import com.cm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author admin
 * @create 2022/5/23 21:54
 */
@Controller
public class RegisteredController {

    @Autowired
    private AdminService service;

    /**
     * 前往registered页面
     * @return
     */
    @RequestMapping("toRegistered")
    public String toRegistered(){
        return "registered";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "registered",method = RequestMethod.POST)
    public String registered(Admin admin){
        service.insert(admin);
        return "login";
    }

}
