package com.cm.controller;

import com.cm.model.User;
import com.cm.service.HotelService;
import com.cm.service.UserService;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService service;
    @Autowired
    private HotelService hService;


    /**
     * 跳转到login页
     * @return
     */
    @RequestMapping({"toLogin","/"})
    public String toLogin(){
        return "login";
    }

    /**
     * 登录
     * @param name
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(String name, String password, Model model, HttpSession session){
        User login = service.login(name, password);
        if (login!= null) {
            session.setAttribute("user",login);
            Tool.setUSER(login);
            model.addAttribute("hotelList",hService.list());
            return "index";
        }else {
            model.addAttribute("msg","登录失败！！！");
            return "login";
        }

    }

    @RequestMapping("out")
    public String out(HttpSession session){

        session.invalidate();
        Tool.setUSER(null);
        return "login";
    }

}
