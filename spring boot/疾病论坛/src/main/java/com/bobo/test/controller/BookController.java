package com.bobo.test.controller;

import com.bobo.test.config.MarkDownConfig;
import com.bobo.test.pojo.User;
import com.bobo.test.pojo.book;
import com.bobo.test.pojo.comment;
import com.bobo.test.service.BookService;
import com.bobo.test.service.UserServiceImpl;
import com.bobo.test.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    commentService commentService;

    @RequestMapping("/book")
    public String toNew(String num, Model model){
        model.addAttribute("book" , bookService.queryBookByUserId(Integer.parseInt(num)));
        List<comment> comments = commentService.queryCommentById(Integer.parseInt(num));
        if(!comments.isEmpty()){
            model.addAttribute("reviews",comments);
        }

        return "book";
    }

    @RequestMapping("/books")
    public String toNews(Model model){
        model.addAttribute("books" , bookService.queryBookAll());
        model.addAttribute("bo" , 1);
        return "index";
    }


    @RequestMapping("/booksPlun")
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
        return "redirect:/book?num="+num;
    }
}
