package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import com.bobo.test.service.specialtyService;
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
    @Autowired
    specialtyService specialtyService;


    /**
     * 注册
     *
     * @param user_num
     * @param user_name
     * @param user_password
     * @param confirm_password
     * @param user_email
     * @param power
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(Long user_num,String user_name,String user_password,String confirm_password,String user_email,String power,String specialty, Model model,HttpSession session) {

        User queryuser = userService.queryUserByNum(user_num);
        User user1 = userService.queryUserByEmail(user_email);
        if(queryuser==null && user1==null && user_password.equals(confirm_password)) {
            User user = new User(user_num,user_name,user_password, LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))),user_email,"/img/logo.png",Integer.valueOf(power),Long.valueOf(specialty));
            userService.addUser(user);
            //为了让注册好的用户快速登录将用户名和密码传到登录页
            session.setAttribute("username",user.getId());
            session.setAttribute("password",user.getPassword());
            return "login";
        }else {
            model.addAttribute("u_num",createId());
            model.addAttribute("specialtys",specialtyService.querySpecialty());
            model.addAttribute("bcz","邮箱已存在或者密码不匹配");
            return "registered";
        }
    }

    @RequestMapping("/registered")
    public String registered(Model model){
        model.addAttribute("u_num",createId());
        model.addAttribute("specialtys",specialtyService.querySpecialty());
        return "registered";
    }

    private Long createId(){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        return Long.valueOf(u_word);
    }

}
