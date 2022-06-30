package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.service.ClassifyService;
import com.bobo.test.service.IkonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    ClassifyService cService;
    @Autowired
    IkonService iService;
    //进入首页
    @RequestMapping({"/index","/","/index.html"})
    public String toIndex(HttpSession session) {
        session.setAttribute("classify",cService.list());
        session.setAttribute("Ikons",iService.list());
        if (Tool.getUSER() != null && iService.listIkonByCollect().size() != 0){
            session.setAttribute("collectIkons",iService.listIkonByCollect());
        }

        return "index";
    }
}
