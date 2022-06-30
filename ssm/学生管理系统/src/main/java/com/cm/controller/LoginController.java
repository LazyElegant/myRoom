package com.cm.controller;

import com.cm.service.AdminService;
import com.cm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author admin
 * @create 2022/5/23 21:57
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService service;
    @Autowired
    private StudentService sService;


    /**
     * 前往login页面
     * @return
     */
    @RequestMapping({"toLogin","/"})
    public String toLogin(){
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("login")
    public String login(String name, String password, Model model){
        if (service.login(name, password)) {
            model.addAttribute("list",sService.list());     // 登录成功返回student信息
            return "index";
        }else {
            model.addAttribute("msg","登录失败！！！");
            return "login";
        }

    }


}
