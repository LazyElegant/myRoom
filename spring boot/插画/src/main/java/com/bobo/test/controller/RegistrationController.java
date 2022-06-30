package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.pojo.Painter;
import com.bobo.test.pojo.User;
import com.bobo.test.service.PainterService;
import com.bobo.test.service.UserService;
import com.bobo.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {


    @Autowired
    UserService uService;
    @Autowired
    PainterService pService;


    @RequestMapping("/toRegistered")
    public String registered(Model model){
        model.addAttribute("id", Tool.getID());
        return "registered";
    }
    //注册
    @PostMapping("/registered")
    public String registered( User user, Model model) {
        if (uService.registration(user)){
            model.addAttribute("username",user.getId());
            model.addAttribute("password",user.getPassword());
            return "login";
        }else {
            model.addAttribute("bcz","用户名已存在或者密码不正确！！！");
            return "redirect:/registered";
        }
    }
    //注册
    @PostMapping("/registeredPainter")
    public String registeredPainter(HttpSession session) {
        pService.insertPainter(new Painter());
        session.setAttribute("user", uService.getUserVoById(Tool.getUserID()));
        return "redirect:/index";
    }
}
