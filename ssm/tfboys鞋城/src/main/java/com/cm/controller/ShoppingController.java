package com.cm.controller;

import com.cm.model.Order;
import com.cm.model.Shopping;
import com.cm.service.AddressService;
import com.cm.service.OrderService;
import com.cm.service.ShoppingService;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author admin
 * @create 2022/5/21 17:48
 */
@Controller
public class ShoppingController {

    @Autowired
    private ShoppingService service;
    @Autowired
    private AddressService aService;

    @RequestMapping("toShopping")
    public String toShopping(Model model){
        if (Tool.getUserID() == null){
            return "login";
        }
        model.addAttribute("shoppingList",service.list(Tool.getUserID()));

        return "shopping";
    }
    @RequestMapping("shopping")
    public String shopping(Integer id){
        if (Tool.getUserID() == null){
            return "login";
        }

        Shopping shopping = new Shopping();
        shopping.setGoodsId(id);
        service.insert(shopping);

        return "redirect:/toShopping";
    }
    @RequestMapping("shop")
    public String shop(Integer id,Integer number,Integer size){
        if (Tool.getUserID() == null){
            return "login";
        }
        Shopping shopping = new Shopping();
        shopping.setGoodsId(id);
        shopping.setSize(size);
        shopping.setAmount(number);
        service.inserts(shopping);

        return "redirect:/toShopping";
    }


    @RequestMapping("updateAmount")
    @ResponseBody
    public int updateAmount(Integer id,Integer amount){
        return service.updateAmount(id, amount);
    }

    @RequestMapping("updateSize")
    @ResponseBody
    public int updateSize(Integer id,Integer size){
        return service.updateSize(id, size);
    }


    @RequestMapping("deleteShopping")
    @ResponseBody
    public int delete(Integer id){
        return service.delete(id);
    }

    @RequestMapping("buy")
    @ResponseBody
    public Double buy(Integer id){

        if (aService.get()==null){
            return -1.0;
        }
        return service.SelectMoney(id);
    }


}
