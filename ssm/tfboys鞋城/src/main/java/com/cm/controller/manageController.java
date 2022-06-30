package com.cm.controller;

import com.cm.dto.UpdateGoodsDto;
import com.cm.service.GoodsService;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author admin
 * @create 2022/5/21 10:48
 */
@Controller
public class manageController {
    @Autowired
    private GoodsService service;

    @RequestMapping("manage")
    public String manage(Model model){

        model.addAttribute("goodsList",service.list(Tool.getUserID()));
        return "manage";
    }

    @RequestMapping("deleteGoods")
    @ResponseBody
    public int delete(Integer id){
        return service.delete(id);
    }

    @RequestMapping("toUpdateGoods")
    public String update(Integer id,Model model){
        model.addAttribute("goods",service.get(id));
        return "updateGoods";
    }
    @RequestMapping("goods")
    public String get(Integer id,Model model){
        model.addAttribute("goods",service.get(id));
        return "good";
    }

    @RequestMapping(value = "updateGoods",method = RequestMethod.POST)
    public String updateGoods(UpdateGoodsDto dto){
        service.update(dto);
        return "redirect:/manage";
    }
}
