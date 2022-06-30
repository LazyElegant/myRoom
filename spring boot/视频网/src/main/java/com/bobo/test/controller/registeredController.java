package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Controller
public class registeredController {

    @Autowired
    UserServiceImpl userService;

    //注册
    @RequestMapping("/addUser")
    public String addUser(Long user_num,String user_name,String user_password,String confirm_password,String user_email, Model model,HttpSession session) {

        User user = null;
        User queryuser = userService.queryUserByNum(user_num);
        User user1 = userService.queryUserByEmail(user_email);
        if(queryuser==null && user_password.equals(confirm_password) && user1==null) {
            user = new User(user_num,user_name,user_password, LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))),user_email,"/img/logo.png");
            userService.addUser(user);
            //为了让注册好的用户快速登录将用户名和密码传到登录页
            session.setAttribute("username",user.getId());
            session.setAttribute("password",user.getPassword());
            return "login";
        }else {
            model.addAttribute("bcz","邮箱已存在或者密码不一致！！！");
            return "registered";
        }
    }

    @RequestMapping("/registered")
    public String registered(Model model){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        model.addAttribute("u_num",u_word);
        return "registered";
    }

}
