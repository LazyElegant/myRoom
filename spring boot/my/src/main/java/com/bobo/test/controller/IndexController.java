package com.bobo.test.controller;

import com.bobo.test.pojo.News;
import com.bobo.test.service.ClassesServiceImpl;
import com.bobo.test.service.NewsServiceImpl;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class IndexController {


    @Autowired
    UserServiceImpl userService;
    @Autowired
    ClassesServiceImpl classesService;
    @Autowired
    NewsServiceImpl newsService;

    //进入首页
    @RequestMapping({"/index","/","/index.html","/ify"})
    public String toindex(HttpSession session, Model model,String s,String cm) {
        Collection<News> news = null;
        String authorName =null;
        if (s!=null){
            news = newsService.queryNewsByName("%"+s+"%");
        }else if(cm!=null){
            news = newsService.queryNewsByIfy(cm);
        }else {
            news = newsService.queryAllNews();
        }
        Collection<News> publish = new ArrayList<News>();
        for (News c: news){
            if(!c.getCurrent_state().equals("editor")){
                publish.add(c);
                authorName = userService.queryUserByNum(c.getNews_author_num()).getUser_name();
            }
        }
        session.setAttribute("publish",publish);
        session.setAttribute("classes",classesService.queryAllClasses());
        model.addAttribute("author",authorName);
        return "index";
    }

    //退出登录，返回登录页
    @RequestMapping("/OutIndex")
    public String OutIndex(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
