package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


@Controller
public class PersonalController {

    @Autowired
    UserService service;

    @RequestMapping("/toPersonal")
    public String toPersonal(){
        return "personal";
    }

    @RequestMapping("/Personal")
    public String Personal(String name, String email, Integer id, HttpSession session){
        service.update(id, email, name);
        session.setAttribute("user", service.getUserVoById(id));
        return "personal";
    }

    @RequestMapping("/personalLogo")
    public String personalLogo(MultipartFile file, HttpSession session){
        service.updatePic(file);
        session.setAttribute("user", service.getUserVoById(Tool.getUserID()));
        return "personal";
    }
}
