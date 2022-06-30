package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.dto.LoginDto;
import com.bobo.test.service.UserService;
import com.bobo.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //进入登录页
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    //判断登录，进入首页
    @PostMapping("/login")
    public String toIndex(LoginDto dto, Model model , HttpSession session) {
        //判断登录
        if (userService.Login(dto)) {
            session.setAttribute("user",Tool.getUSER());
            session.setAttribute("id",Tool.getUSER().getId());
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "用户名或密码错误！！！");
            return "login";
        }
    }

    //退出登录，返回登录页
    @RequestMapping("/OutLogin")
    public String OutIndex(HttpSession session){
        session.invalidate();
        Tool.setUSER(null);
        return "redirect:/index";
    }
}
