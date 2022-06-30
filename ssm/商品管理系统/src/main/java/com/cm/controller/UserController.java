package com.cm.controller;

import com.cm.model.User;
import com.cm.service.UserService;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author admin
 * @create 2022/5/25 16:48
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转修改密码页
     * @return
     */
    @RequestMapping("updatePassword")
    public String updatePassword(){
        return "updatePassword";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("updatepaw")
    public String updatepaw(String oldPassword, String newPassword, Model model){
        System.out.println(oldPassword);

        User user = Tool.getUSER();
        System.out.println(user.getPassword());
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            Tool.setUSER(user);
            userService.update(newPassword);
        }else {
            model.addAttribute("msg","原密码错误!!!");
        }
        return "updatePassword";
    }

}
