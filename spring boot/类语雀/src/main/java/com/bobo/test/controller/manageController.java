package com.bobo.test.controller;

import com.bobo.test.config.MarkDownConfig;
import com.bobo.test.pojo.News;
import com.bobo.test.pojo.User;
import com.bobo.test.service.NewsServiceImpl;
import com.bobo.test.service.UserServiceImpl;
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
import java.util.UUID;

@Controller
public class manageController {

    @Autowired
    NewsServiceImpl newsService;

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/manage")
    public String toPersonal(){
        return "manage";
    }

    @RequestMapping("/addNews")
    public String addNews(HttpSession session,String pdUpdate, MultipartFile pictures, MultipartFile UpdatePictures, String btn, String Module, String name, String text, String editor, String publish){
        MarkDownConfig markDownConfig = new MarkDownConfig();
        text = markDownConfig.translateToHtmlInline(text);
        if (btn != null && Module != null){
            String logo = null;
            String filename = "";
            String news_num = "";
            boolean value = true;
            if(pdUpdate.equals("aa")) {
                filename = pictures.getOriginalFilename();
                if (!(filename.length()>0)) filename = "/img/logo.png";
                int num = 0;
                for(int i = 0; i < 9; i++) {
                    num = (int)(Math.random()*10);
                    news_num = news_num + num;
                }
            }else{
                filename = UpdatePictures.getOriginalFilename();
                if (!(filename.length()>0)) filename = newsService.queryNewsByNum(pdUpdate).getNews_pic();
                news_num = pdUpdate;
                value = false;
            }
            News news1 = newsService.queryNewsByNum(pdUpdate);
            if(news1!=null) pdUpdate = news1.getNews_pic();

            if(!filename.equals("/img/logo.png") && !filename.equals(pdUpdate)){

                String prefix = filename.substring(filename.lastIndexOf(".") + 1);
                String destFilename = UUID.randomUUID().toString().replace("-", "") + "." + prefix;
                String fileUrl = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
                File destImage = new File(fileUrl, destFilename);
                try {
                    pictures.transferTo(destImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logo = "/img/" + destFilename;
            }else {
                logo = filename;
            }
            News news;
            Calendar calendar= Calendar.getInstance();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            User user = (User) session.getAttribute("user");
            name = "" + user.getUser_num();
            if (editor == null) {
                news = new News(Integer.parseInt(news_num), Module, btn, logo, name, text, "editor", dateFormat.format(calendar.getTime()));
            }else {
                news = new News(Integer.parseInt(news_num), Module, btn, logo, name, text, "publish", dateFormat.format(calendar.getTime()));
            }

            if (value){
                newsService.addNews(news);
            }else {
                newsService.updateNews(news);
            }
        }
        return "redirect:/journalism";
    }


    @RequestMapping("/updateNews")
    public String updateNews(String num, Model model){
        News news = newsService.queryNewsByNum(num);
        MarkDownConfig markDownConfig = new MarkDownConfig();
        news.setNews_text(markDownConfig.UpdateTranslateToHtmlInline(news.getNews_text()));
        model.addAttribute("Updatenews", news);
        return "manage";
    }


    @RequestMapping("/deleteNews")
    public String deleteNews(String num){
        newsService.deleteNews(num);
        return "redirect:/journalism";
    }
}
