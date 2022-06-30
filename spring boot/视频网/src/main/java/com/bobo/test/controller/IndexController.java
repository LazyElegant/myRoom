package com.bobo.test.controller;

import com.bobo.test.pojo.classes;
import com.bobo.test.pojo.classify;
import com.bobo.test.service.UserServiceImpl;
import com.bobo.test.service.classesService;
import com.bobo.test.service.classifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    classifyService classifyService;

    @Autowired
    classesService classesService;

    //进入首页
    @RequestMapping({"/index","/","/index.html","/ify"})
    public String toindex( Model model ,HttpSession session) {
        List<classify> classifies = classifyService.listClassify();
        List<classes> classes =new ArrayList<>();
        session.setAttribute("classifys",classifies);
        for (classify classify : classifies) {
            List<classes> clazz = classesService.listClassesByClassifyId(classify.getId(), 0, 6);
            for (classes clazz1 : clazz) {
                classes.add(clazz1);
            }
        }
        session.setAttribute("classes",classes);
        return "index";
    }

    //退出登录，返回登录页
    @RequestMapping("/OutIndex")
    public String OutIndex(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
