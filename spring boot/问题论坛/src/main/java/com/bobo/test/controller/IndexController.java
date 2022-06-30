package com.bobo.test.controller;

import com.bobo.test.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    IssueService iService;

    //进入首页
    @RequestMapping({"/index","/","/index.html"})
    public String toIndex(HttpSession session) {
        session.setAttribute("Issues",iService.listIssue());
        return "tribune";
    }
}
