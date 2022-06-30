package com.cm.controller;

import com.cm.service.ClassifyService;
import com.cm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private ClassifyService service;
	@Autowired
	private GoodsService gService;

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getAllUsers(HttpSession session,Model model) {
		model.addAttribute("indexList",gService.listIndex());
		session.setAttribute("Classify",service.list());
		return "index";
	}

}
