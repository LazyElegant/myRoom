package com.cm.controller;

import com.cm.dto.GoodsDto;
import com.cm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Author admin
 * @create 2022/5/20 20:18
 */
@Controller
public class ShelvesController {
    @Autowired
    private GoodsService service;

    @RequestMapping("shelves")
    public String shelves(){
        return "shelves";
    }


    @RequestMapping(value = "insertGoods" ,method = RequestMethod.POST)
    public String insertGoods(GoodsDto dto){
        service.insert(dto);
        return "shelves";
    }


}
