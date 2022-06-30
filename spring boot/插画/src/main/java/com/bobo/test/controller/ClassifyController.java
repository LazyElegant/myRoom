package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.pojo.Classify;
import com.bobo.test.service.ClassifyService;
import com.bobo.test.service.IkonService;
import com.bobo.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    ClassifyService service;
    @Autowired
    IkonService iService;


    @RequestMapping
    public String toClassify(HttpSession session) {
        session.setAttribute("classify",service.list());
        return "classify";
    }

    @RequestMapping("/insertClassify")
    public String insertClassify(String name){
        service.insertClassify(new Classify(Tool.getID(),name, LocalDateTime.now()));
        return "redirect:/classify";
    }

    @RequestMapping("updateClassify")
    private String updateClassify(String name,Integer id){
        service.update(id, name);
        return "redirect:/classify";
    }

    @RequestMapping("/ify")
    private String ify(Integer id,Model model){
        model.addAttribute("ifys",iService.listIkonByClassify(id));
        return "ifyIkon";
    }

    @RequestMapping("/ifyByConcern")
    private String ifyByConcern(Model model){
        model.addAttribute("ifys",iService.listIkonByConcern());
        return "ifyIkon";
    }
    @RequestMapping("/ifyByCollect")
    private String ifyByCollect(Model model){
        model.addAttribute("ifys",iService.listIkonByCollect());
        return "ifyIkon";
    }

    @RequestMapping("/seek")
    private String likeIkon(String title,Model model){
        model.addAttribute("ifys",iService.likeIkon(title));
        return "ifyIkon";
    }


}
