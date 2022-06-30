package com.bobo.test.controller;

import com.bobo.test.service.classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class classifyController {

    @Autowired
    classesService classesService;

    @GetMapping("/ify")
    public String toClassify(Model model , HttpSession session, String cm, int page){

        session.setAttribute("classes",classesService.listClassesByClassifyId(Long.valueOf(cm), (page-1)*9, 9));
            model.addAttribute("number",classesService.getClassesCount(Long.valueOf(cm)));
        model.addAttribute("classify",cm);
        model.addAttribute("page",page);
        return "classify";
    }
}
