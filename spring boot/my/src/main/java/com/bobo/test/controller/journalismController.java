package com.bobo.test.controller;

import com.bobo.test.pojo.News;
import com.bobo.test.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class journalismController {

    @Autowired
    NewsServiceImpl newsService;

    @RequestMapping("/journalism")
    public String toPersonal(HttpSession session){
        Collection<News> news = newsService.queryAllNews();
        Collection<News> editor = new ArrayList<News>();
        Collection<News> publish = new ArrayList<News>();
        for (News c: news){
            if(c.getCurrent_state().equals("editor")){
                editor.add(c);  
            }else{
                publish.add(c);
            }
        }
        session.setAttribute("editor",editor);
        session.setAttribute("publish",publish);
        return "journalism";
    }

}
