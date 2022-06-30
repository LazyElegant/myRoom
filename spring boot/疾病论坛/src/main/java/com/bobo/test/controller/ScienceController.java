package com.bobo.test.controller;

import com.bobo.test.pojo.comment;
import com.bobo.test.service.ScienceServiceImpl;
import com.bobo.test.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class ScienceController {

    @Autowired
    ScienceServiceImpl scienceService;
    @Autowired
    commentService commentService;


    @RequestMapping("/science")
    public String toNew(String num, Model model){
        model.addAttribute("science" , scienceService.queryScienceById(Integer.parseInt(num)));
        List<comment> comments = commentService.queryCommentById(Integer.parseInt(num));
        if(!comments.isEmpty()){
            model.addAttribute("reviews",comments);
        }
        return "science";
    }

    @RequestMapping("/sciences")
    public String toNews( Model model){
        model.addAttribute("sciences" , scienceService.queryScienceAll());
        return "scienceShow";
    }


    @RequestMapping("/sciencePlun")
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
        return "redirect:/science?num="+num;
    }
}
