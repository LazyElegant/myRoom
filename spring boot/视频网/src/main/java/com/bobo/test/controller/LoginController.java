package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;
    //进入登录页
    @RequestMapping("/login")
    public String toLogin( Model model ,HttpSession session) {

        //如果是注册后进入登录页就将账号密码放在输入框中方便登入
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("password", session.getAttribute("password"));


        return "login";
    }


    //判断登录，进入首页
    @GetMapping("/toIndex")
    public String toIndex(Long user_num, String user_password, Model model , HttpSession session) {

        //通过名字查询
        User user = userService.queryUserByNum(user_num);

        //判断登录
        if (user!=null && user.getPassword().equals(user_password)) {
            session.setAttribute("user",user);
            return "redirect:/index";
        } else {
            model.addAttribute("msg","用户名或密码错误！！！");
            return "login";
        }
    }

}
