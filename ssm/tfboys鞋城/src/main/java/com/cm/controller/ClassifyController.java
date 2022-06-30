package com.cm.controller;

import com.cm.model.Classify;
import com.cm.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author admin
 * @create 2022/5/24 19:33
 */
@Controller
public class ClassifyController {

    @Autowired
    private ClassifyService service;

    @RequestMapping("classifyManage")
    public String classifyManage(Model model){
        model.addAttribute("classifyList",service.list());
        return "classifyManage";
    }

    @RequestMapping("addClassify")
    public String addClassify(String name, Model model, HttpSession session){
        service.add(name);
        model.addAttribute("classifyList",service.list());
        session.setAttribute("Classify",service.list());
        return "redirect:/classifyManage";
    }

    @RequestMapping("deleteClasses")
    public String deleteClasses(Integer id,Model model, HttpSession session){
        service.delete(id);
        model.addAttribute("classifyList",service.list());
        session.setAttribute("Classify",service.list());
        return "redirect:/classifyManage";
    }

    @RequestMapping("updateClasses")
    public String updateClasses(Classify classify, Model model, HttpSession session){
        service.update(classify);
        model.addAttribute("classifyList",service.list());
        session.setAttribute("Classify",service.list());
        return "redirect:/classifyManage";
    }
}
