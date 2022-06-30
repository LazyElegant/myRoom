package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class personalController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/toPersonal")
    public String toPersonal(){
        return "personal";
    }

    @RequestMapping("/Personal")
    public String Personal(String user_name,String user_email,String user_num,String date,String status,Model model,HttpSession session){
        int rn = userService.updateUser(user_num,user_name,user_email);
        if(rn != 0){
            session.setAttribute("user", userService.queryUserByNum(user_num));
            userService.queryUserByNum(user_num);
            return "redirect:/index";
        }else{
            model.addAttribute("msg","修改失败！！！");
            return "personal";
        }
    }
}
