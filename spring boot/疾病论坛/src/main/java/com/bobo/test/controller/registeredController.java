package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class registeredController {

    @Autowired
    UserServiceImpl userService;

    //注册
    @RequestMapping("/addUser")
    public String addUser(int user_num,String user_name,String user_password,String confirm_password,String user_email, Model model,HttpSession session) {

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        User user = null;
        User queryuser = userService.queryUserByNum(user_num);
        if(queryuser==null && user_password.equals(confirm_password)) {

            user = new User(user_num,user_name,user_email,user_password,"/img/logo.png");
            userService.addUser(user);

            //为了让注册好的用户快速登录将用户名和密码传到登录页
            session.setAttribute("username",user.getId());
            session.setAttribute("password",user.getPassword());
            return "login";
        }else {
            model.addAttribute("bcz","用户名已存在或者密码不正确！！！");
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
