package com.cm.controller;

import com.cm.dto.UpdateGoodsDto;
import com.cm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author admin
 * @create 2022/5/21 16:30
 */
@Controller
public class listController {

    @Autowired
    private GoodsService service;

    @RequestMapping("list")
    public String list(Model model,Integer page){
        model.addAttribute("List",service.listAll((page-1)*5, 5));
        model.addAttribute("number",service.getAllGoodsNum());
        model.addAttribute("page",page);
        return "list";
    }
    @RequestMapping("listByClass")
    public String updateGoods(Integer id,Model model,Integer page){
        model.addAttribute("List",service.listGoodsByClass(id,(page-1)*5, 5));
        model.addAttribute("id",id);
        model.addAttribute("number",service.getGoodsNum(id));
        model.addAttribute("page",page);
        return "listClass";
    }
}
