package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.pojo.comment;
import com.bobo.test.pojo.forum;
import com.bobo.test.service.forumService;
import com.bobo.test.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class ForumController {

    @Autowired
    forumService forumService;
    @Autowired
    commentService commentService;

    @RequestMapping("/forum")
    public String toNew(String num, Model model){
        model.addAttribute("forum" , forumService.queryForumById(Integer.parseInt(num)));
        List<comment> comments = commentService.queryCommentById(Integer.parseInt(num));
        if(!comments.isEmpty()){
            model.addAttribute("reviews",comments);
        }
        return "forum";
    }

    @RequestMapping("/forums")
    public String toNews(Model model){
        model.addAttribute("forums" , forumService.queryForumAll());

        return "forumShow";
    }

    @RequestMapping("/deleteForum")
    public String deleteForum(String num,HttpSession session, Model model){
        forumService.deleteForum(Integer.parseInt(num));
        commentService.deleteComment(Integer.parseInt(num));
        User user = (User) session.getAttribute("user");
        model.addAttribute("forums" , forumService.queryForumByUserId(user.getId()));
        return "journalism";
    }

    @RequestMapping("/addForum")
    public String addForum(String btn,String name,String text,HttpSession session, Model model){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String id = "";
        int nu = 0;
        for(int i = 0; i < 9; i++) {
            nu = (int)(Math.random()*10);
            id = id + nu;
        }
        forum forum = new forum(Integer.parseInt(id),btn,text,Integer.parseInt(name),dateFormat.format(calendar.getTime()));
        forumService.addForum(forum);
        User user = (User) session.getAttribute("user");
        model.addAttribute("forums" , forumService.queryForumByUserId(user.getId()));
        return "journalism";
    }
    @RequestMapping("/manage")
    public String manage(){
        return "manage";
    }

    @RequestMapping("/journalism")
    public String journalism(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("forums" , forumService.queryForumByUserId(user.getId()));
        return "journalism";
    }
    @RequestMapping("/forumPlun")
    public String plun(String num,String pluntext,String name_num,String name, Model model){
        Calendar calendar= Calendar.getInstance();
        String id = "";
        int nu = 0;
        for(int i = 0; i < 9; i++) {
            nu = (int)(Math.random()*10);
            id = id + nu;
        }
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment review = new comment(Integer.parseInt(id),Integer.parseInt(num),Integer.parseInt(name_num),dateFormat.format(calendar.getTime()),pluntext);
        commentService.addComment(review);
        return "redirect:/forum?num="+num;
    }
}
