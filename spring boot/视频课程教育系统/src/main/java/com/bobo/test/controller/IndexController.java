package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.service.UserServiceImpl;
import com.bobo.test.service.classesService;
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
    classesService classesService;

    //进入首页
    @RequestMapping({"/index","/","/index.html","/ify"})
    public String toindex( Model model ,HttpSession session, Integer page) {
        User user = (User) session.getAttribute("user");
        if (page != null) {
            session.setAttribute("classes", classesService.pageClassesBySpecialtyId(user.getSpecialty_id(), (page - 1) * 9, 9));
        }else {
            session.setAttribute("classes", classesService.pageClassesBySpecialtyId(user.getSpecialty_id(), 0, 9));
            page =1;
        }
        model.addAttribute("number",classesService.getClassesCount(user.getSpecialty_id())+1);
        model.addAttribute("page",page);
        return "index";
    }

    //退出登录，返回登录页
    @RequestMapping("/OutIndex")
    public String OutIndex(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
