package com.bobo.test.controller;

import com.bobo.test.pojo.User;
import com.bobo.test.pojo.Video;
import com.bobo.test.pojo.WatchHistory;
import com.bobo.test.pojo.classes;
import com.bobo.test.service.VideoService;
import com.bobo.test.service.WatchHistoryService;
import com.bobo.test.service.classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class classesController {

    @Autowired
    classesService classesService;
    @Autowired
    WatchHistoryService watchHistoryService;
    @Autowired
    VideoService videoService;

    @GetMapping("/class")
    public String toClasses(Model model , HttpSession session, String num){

        User user = (User) session.getAttribute("user");
        List<WatchHistory> watchHistoryByUserId = watchHistoryService.getWatchHistoryByUserId(user.getId());
        classes classes = classesService.listClassesById(Long.valueOf(num));
        List<classes> classes1 = classesService.listClassesBySpecialtyId(classes.getSpecialty_id());
        for (classes classes2 : classes1) {

            // 拿到所有num比传参小的class
            if (classes2.getNum() < classes.getNum()) {
                //拿到该class下的所有视频
                List<Video> videoByClassesId = videoService.getVideoByClassesId(classes2.getId());
                for (Video video : videoByClassesId) {
                    boolean b = false;

                    for (WatchHistory watchHistory : watchHistoryByUserId) {
                            //判断该视频是否看过

                        if (video.getId().equals(watchHistory.getVideo_id())) {
                            b= true;
                        }
                    }

                    //没看过直接跳msg
                    if (!b){

                        Object msg = session.getAttribute("msg");
                        if (msg != null) {
                            session.removeAttribute("msg");
                            model.addAttribute("classes",classes);
                            model.addAttribute("videos",videoService.getVideoByClassesId(Long.valueOf(num)));
                            return "classes";

                        }

                        session.setAttribute("classes",classesService.pageClassesBySpecialtyId(user.getSpecialty_id(),0,9));
                        model.addAttribute("number",classesService.getClassesCount(user.getSpecialty_id())+1);
                        model.addAttribute("page",1);
                        session.setAttribute("msg",1);
                        return "index";
                    }

                }
            }
        }
        //全部看过进入class
        model.addAttribute("classes",classes);
        model.addAttribute("videos",videoService.getVideoByClassesId(Long.valueOf(num)));
        return "classes";
    }

    @GetMapping("/sx")
    public String sxClasses( HttpSession session, String link){
        List<classes> classesCountByName = classesService.getClassesCountByName(link);

        session.setAttribute("classes",classesCountByName);
        return "index";
    }


}
