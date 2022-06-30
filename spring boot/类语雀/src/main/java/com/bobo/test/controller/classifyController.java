package com.bobo.test.controller;

import com.bobo.test.pojo.Classes;
import com.bobo.test.service.ClassesServiceImpl;
import com.bobo.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class classifyController {

    @Autowired
    ClassesServiceImpl classesService;

    @RequestMapping("/classify")
    public String toPersonal(HttpSession session){
        session.setAttribute("classes",classesService.queryAllClasses());
        return "classify";
    }

    @RequestMapping("/classify/addClasses")
    public String addClasses(String ify_name){
        String ify_num = "";
        int num = 0;
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            //System.out.println(num);
            ify_num = ify_num + num;
        }
        Classes classes = new Classes(Integer.parseInt(ify_num),ify_name);
        classesService.addClasses(classes);
        return "redirect:/classify";
    }
    @RequestMapping("/classify/deteleClasses")
    public String deteleClasses(String ify_num){
        classesService.deleteClasses(ify_num);
        return "redirect:/classify";
    }
    @RequestMapping("/classify/updateClasses")
    public String updateClasses(String ify_num,String ify_name){
        Classes classes = new Classes(Integer.parseInt(ify_num),ify_name);
        classesService.updaleClasses(classes);
        return "redirect:/classify";
    }
}
