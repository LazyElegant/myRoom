package com.bobo.test.controller;

import com.bobo.test.service.PainterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/painterManage")
public class painterManageController {


    @Autowired
    PainterService service;

    //进入画师管理页面
    @RequestMapping
    public String painterManage(Model model) {
        model.addAttribute("painters",service.listPainter());
        return "painterManage";
    }

    @RequestMapping("/throughPainter")
    public String throughPainter(Integer id){
        service.updatePainter(2,id);
        return "redirect:/painterManage";
    }

    @RequestMapping("/rejectPainter")
    public String rejectPainter(Integer id){
        service.updatePainter(1,id);
        return "redirect:/painterManage";
    }

    @RequestMapping("/banPainter")
    public String banPainter(Integer id){
        service.updatePainter(3,id);
        return "redirect:/painterManage";
    }

    @RequestMapping("/unbanPainter")
    public String unbanPainter(Integer id){
        service.updatePainter(2,id);
        return "redirect:/painterManage";
    }
}
