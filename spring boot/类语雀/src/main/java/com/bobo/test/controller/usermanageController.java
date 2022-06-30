package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class usermanageController {

    @Autowired
    UserServiceImpl userService;
    
    @RequestMapping("/usermanage")
    public String toPersonal(HttpSession session){
        session.setAttribute("users", userService.queryUserByStatus());
        return "usermanage";
    }
    @RequestMapping("/usermanage/deteleUser")
    public String deteleUser(String user_num){
        userService.deteleUser(user_num);
        return "redirect:/usermanage";
    }
    @RequestMapping("/usermanage/updateUser")
    public String updateUserPassword(String user_num,String user_password){
        userService.updateUserPassword(user_num,user_password);
        return "redirect:/usermanage";
    }
}
