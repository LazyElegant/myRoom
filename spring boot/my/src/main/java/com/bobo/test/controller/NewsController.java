package com.bobo.test.controller;

import com.bobo.test.pojo.News;
import com.bobo.test.pojo.Review;
import com.bobo.test.service.NewsServiceImpl;
import com.bobo.test.service.ReviewServiceImpl;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Controller
public class NewsController {

    @Autowired
    NewsServiceImpl newsService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ReviewServiceImpl reviewService;

    @RequestMapping("/news")
    public String toNews(String num, Model model){
        News news = newsService.queryNewsByNum(num);

        model.addAttribute("News",news);
        model.addAttribute("author",userService.queryUserByNum("" + news.getNews_author_num()).getUser_name());
        Collection<Review> reviews = reviewService.queryNewsByNum(num);
        if(!reviews.isEmpty()){
            model.addAttribute("review",reviews);
        }
        return "news";
    }

    @RequestMapping("/plun")
    public String plun(String num,String pluntext,String name, Model model){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Review review = new Review(Integer.parseInt(num),pluntext,name,dateFormat.format(calendar.getTime()));
        reviewService.addReview(review);
        model.addAttribute("News",newsService.queryNewsByNum(num));
        model.addAttribute("review",reviewService.queryNewsByNum(num));
        return "news";
    }

}
