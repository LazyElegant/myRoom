package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.pojo.Video;
import com.bobo.test.pojo.WatchHistory;
import com.bobo.test.service.VideoService;
import com.bobo.test.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WatchHistoryController {

    @Autowired
    WatchHistoryService watchHistoryService;
    @Autowired
    VideoService videoService;

    @GetMapping("/history")
    public String toHistory(Model model , HttpSession session){
        User user = (User) session.getAttribute("user");
        List<WatchHistory> watchHistoryByUserId = watchHistoryService.getWatchHistoryByUserId(user.getId());
        List<Video> videos= new ArrayList<Video>();
        for (WatchHistory watchHistory : watchHistoryByUserId) {
            Video video = videoService.getVideoById(watchHistory.getVideo_id());
            video.setCreate_time(watchHistory.getCreate_time());
            videos.add(video);
        }

        model.addAttribute("watchHistory",videos);
        return "history";
    }
    @GetMapping("/deleteHistory")
    public String deleteHistory(Model model , HttpSession session){
        User user = (User) session.getAttribute("user");
        watchHistoryService.deleteHistory(user.getId());
        List<Video> videos= new ArrayList<Video>();
        model.addAttribute("watchHistory",videos);
        return "history";
    }
}
