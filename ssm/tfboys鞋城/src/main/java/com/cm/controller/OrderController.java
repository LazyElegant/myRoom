package com.cm.controller;

import com.cm.model.Order;
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
 * @create 2022/5/21 23:42
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService oService;
    @Autowired
    private ShoppingService sService;

    @RequestMapping("orderMapper")
    public String orderMapper(Model model){
        model.addAttribute("orderList",oService.list(Tool.getUserID()));
        return "orderMapper";
    }
    @RequestMapping("buyTrue")
    @ResponseBody
    public int buyTrue(Integer id,Integer goodsId){
        Order order = new Order();
        order.setShoppingId(id);
        order.setGoodsId(goodsId);
        oService.insert(order);
        sService.delete(id);
        return 1;
    }

    @RequestMapping("refund")
    @ResponseBody
    public int refund(Integer id,Integer status,Model model){
        oService.refund(id, status);
        return 1;
    }


    @RequestMapping("adminOrder")
    public String adminMapper(Model model){
        model.addAttribute("orderList",oService.listAdminOrder(Tool.getUserID()));
        return "adminOrder";
    }
}
