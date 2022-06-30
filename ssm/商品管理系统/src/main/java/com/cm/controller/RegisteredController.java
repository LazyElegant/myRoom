package com.cm.controller;

import com.cm.model.User;
import com.cm.service.UserService;
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
    private UserService service;

    /**
     * 跳转到注册页
     * @return
     */
    @RequestMapping("toRegistered")
    public String toRegistered(){
        return "registered";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "registered",method = RequestMethod.POST)
    public String registered(User user){
        service.insert(user);
        return "login";
    }

}
