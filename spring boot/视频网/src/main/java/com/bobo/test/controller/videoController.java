package com.bobo.test.controller;


import com.bobo.test.pojo.*;
import com.bobo.test.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class videoController {

    @Autowired
    VideoService videoService;
    @Autowired
    WatchHistoryService watchHistoryService;
    @Autowired
    commentService commentService;
    @Autowired
    ReplyService replyService;
    @Autowired
    PeriodService periodService;

    @GetMapping("/video")
    public String toVideo(Model model , String cm){
        model.addAttribute("video",videoService.getVideoById(Long.valueOf(cm)));

        List<comment> comments = commentService.queryCommentById(Long.valueOf(cm));
        if(!comments.isEmpty()){
            model.addAttribute("reviews",comments);
        }
        List<Reply> replies = replyService.listReply();
        if (!replies.isEmpty()) {
            model.addAttribute("replys",replies);
        }
        return "video";
    }

    @RequestMapping("/videoPlun")
    public String plun(String num,String pluntext,String name_num,String name, Model model){
        Calendar calendar= Calendar.getInstance();
        pluntext = filter(pluntext);
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment review = new comment(getId(),Long.valueOf(num),Long.valueOf(name_num),dateFormat.format(calendar.getTime()),pluntext);
        commentService.addComment(review);
        return "redirect:/video?cm="+num;
    }

    @RequestMapping("/reply")
    public String reply(Long point,Long comment,Long video,String text, HttpSession session){
        User user = (User) session.getAttribute("user");
        text = filter(text);
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        replyService.addReply(new Reply(getId(),point,text,dateFormat.format(calendar.getTime()),user.getId(),comment));
        return "redirect:/video?cm="+video;
    }

    @RequestMapping("/deletePlun")
    public String deletePlun(Long id,Long video){
        commentService.deleteComment(id);
        replyService.deleteReplyByCommentId(id);
        return "redirect:/video?cm="+video;
    }


    @RequestMapping("/deleteReply")
    public String deleteReply(Long id,Long video){
        replyService.deleteReply(id);
        return "redirect:/video?cm="+video;
    }

    private String filter(String text){
        String[] old = {"cnm","tmd","草泥马","他妈的","操"};

        for (String s : old) {
            String replacement = "";
            for (int i = 0; i < s.length(); i++) {
                replacement += "*";
            }
            text = text.replaceAll(s,replacement);
        }
        return text;
    }

    @RequestMapping("/WatchHistory")
    @ResponseBody
    public void WatchHistory(@Param("current")String current,HttpSession session,@Param("videoId")String videoId,@Param("period") String period){
        WatchHistory watchHistory = new WatchHistory();
        watchHistory.setId(getId());
        User user = (User) session.getAttribute("user");
        watchHistory.setUser_id(user.getId());
        watchHistory.setVideo_id(Long.valueOf(videoId));
        String format = "YYYY-MM-dd hh:mm:ss";
        String formatDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
        watchHistory.setCreate_time(formatDateTime);
        watchHistory.setCurrentTime(Double.valueOf(current));
        watchHistoryService.insertWatchHistory(watchHistory);
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (Long.valueOf(period) > 0) {
            periodService.addPeriod(new Period(getId(),dateFormat.format(calendar.getTime()),Long.valueOf(period),user.getId(),Long.valueOf(videoId)));
        }
    }

    @RequestMapping("/getWatchHistoryService")
    @ResponseBody
    public Double getWatchHistoryService(@Param("videoId")String videoId,HttpSession session){
        User user = (User) session.getAttribute("user");
        List<WatchHistory> watchHistoryById = watchHistoryService.getWatchHistoryById(user.getId(), Long.valueOf(videoId));
        if (!watchHistoryById.isEmpty()) {
            return watchHistoryById.get(0).getCurrentTime();
        }
        return 0.00;
    }

    private Long getId(){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        return Long.valueOf(u_word);
    }

}

