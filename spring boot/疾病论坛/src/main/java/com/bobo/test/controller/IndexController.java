package com.bobo.test.controller;

import com.bobo.test.service.BookService;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BookService bookService;

    //进入首页
    @RequestMapping({"/index","/","/index.html","/ify"})
    public String toindex( Model model ) {
        model.addAttribute("books",bookService.queryBookAll());
        model.addAttribute("index",1);
        return "index";
    }

    //退出登录，返回登录页
    @RequestMapping("/OutIndex")
    public String OutIndex(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
