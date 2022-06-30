package com.cm.controller;

import com.cm.dto.UpdateUserDto;
import com.cm.dto.UserDto;
import com.cm.model.User;
import com.cm.service.UserService;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author admin
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="toLogin",method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value="toRegistered",method = RequestMethod.GET)
	public String toRegistered(Model model) {
		model.addAttribute("id", Tool.getID());
		return "registered";
	}


	@RequestMapping(value="registered",method = RequestMethod.POST)
	public String registered(Model model, User user,String confirm_password) {
		if (confirm_password.equals(user.getPassword())){

			userService.addUser(user);
			model.addAttribute("id",user.getId());
			model.addAttribute("password",user.getPassword());
			return "login";
		}else {
			model.addAttribute("msg","密码与确认密码不一致！");
			model.addAttribute("id", Tool.getID());
			return "registered";
		}

	}


	@RequestMapping(value="login",method = RequestMethod.POST)
	public String getUser(UserDto dto, HttpSession session,Model model) {
		User login = userService.login(dto);
		if (login != null){
			Tool.setUSER(login);
			session.setAttribute("user",login);
			return "redirect:/index/";
		}else {
			model.addAttribute("msg","登录失败！！！");
			return "login";
		}
	}

	@RequestMapping(value="outLogin",method = RequestMethod.GET)
	public String getUser(HttpSession session) {
		session.invalidate();
		Tool.setUSER(null);
		return "index";
	}

	@RequestMapping("personal")
	public String personal(Model model){
		model.addAttribute("tt","1");
		return "personal";
	}

	@RequestMapping(value = "updateUser" ,method = RequestMethod.POST)
	public String updateUser(UpdateUserDto dto,HttpSession session,Model model){
		model.addAttribute("tt","123");
		if (userService.updateUser(dto)){
			session.setAttribute("user",Tool.getUSER());
		}
		return "personal";
	}

	@RequestMapping("updatePassword")
	public String updatePassword(){
		return "updatePassword";
	}

	@RequestMapping("updatepaw")
	public String updatepaw(String oldPassword,String newPassword,String confirm,Model model){
		User user = Tool.getUSER();
		if(!confirm.equals(newPassword)) {
			model.addAttribute("msg","确认密码与新密码不一致!!!");
		}else if (!user.getPassword().equals(oldPassword)) {
			model.addAttribute("msg","原密码错误!!!");
		}else {
			user.setPassword(newPassword);
			Tool.setUSER(user);
			userService.update(newPassword);
			model.addAttribute("tt","123");

		}
		return "updatePassword";
	}
}
