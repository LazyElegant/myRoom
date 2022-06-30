package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class PersonalController {

    @Autowired
    UserService service;

    @RequestMapping("/toPersonal")
    public String toPersonal(){
        return "personal";
    }

    @RequestMapping("/Personal")
    public String Personal(User user, HttpSession session){
        service.update(user);
        session.setAttribute("user", service.getUserById(user.getId()));
        return "personal";
    }

    @RequestMapping("/toUserManage")
    public String toUserManage(Model model){
        model.addAttribute("Users", service.listUser());
        return "userManage";
    }
}
