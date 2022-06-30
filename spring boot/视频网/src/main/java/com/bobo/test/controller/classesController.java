package com.bobo.test.controller;

import com.bobo.test.pojo.Video;
import com.bobo.test.pojo.classes;
import com.bobo.test.service.VideoService;
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
    VideoService videoService;

    @GetMapping("/class")
    public String toClasses(Model model , HttpSession session, String num){

        model.addAttribute("classes",classesService.listClassesById(Long.valueOf(num)));
        List<Video> videoByClassesId = videoService.getVideoByClassesId(Long.valueOf(num));
        model.addAttribute("videos",videoService.getVideoByClassesId(Long.valueOf(num)));
        return "classes";
    }

    @GetMapping("/sx")
    public String sxClasses(Model model , HttpSession session, String link){
        List<classes> classesCountByName = classesService.getClassesCountByName(link);
        session.setAttribute("classes",classesCountByName);
        return "classify";
    }
}
