package com.cm.controller;

import com.cm.model.Order;
import com.cm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    /**
     * 跳转到添加订单页
     * @return
     */
    @RequestMapping("toAddOrder")
    public String toAddOrder(){
        return "addOrder";
    }

    /**
     * 跳转到修改订单页
     * @return
     */
    @RequestMapping("toUpdateOrder")
    public String toUpdateOrder(Integer id ,Model model){
        model.addAttribute("order",service.getById(id));
        return "updateOrder";
    }

    /**
     * 跳转到index
     * @return
     */
    @RequestMapping("index")
    public String toIndex(Model model){
        model.addAttribute("orderList",service.list());
        return "index";
    }

    /**
     * 添加订单
     * @return
     */
    @RequestMapping("insertOrder")
    public String insertOrder(Order order, Model model){
        service.insert(order);
        model.addAttribute("orderList",service.list());
        return "index";
    }

    /**
     * 通过订单名查询
     * @return
     */
    @RequestMapping("getOrder")
    public String getOrder(String name,Model model){
        model.addAttribute("orderList",service.get(name));
        return "index";
    }

    /**
     * 跳转到管理页
     * @return
     */
    @RequestMapping("manage")
    public String manage(Model model){
        model.addAttribute("orderList",service.list());
        return "manage";
    }

    /**
     * 删除订单
     * @return
     */
    @RequestMapping("deleteOrder")
    public String deleteOrder(Integer id,Model model){
        service.delete(id);
        model.addAttribute("orderList",service.list());
        return "manage";
    }

    /**
     * 批量删除订单
     * @return
     */
    @RequestMapping("deleteOrderList")
    public String deleteOrderList(String ids,Model model){
        service.deleteList(ids);
        model.addAttribute("orderList",service.list());
        return "manage";
    }

    /**
     * 修改订单
     * @return
     */
    @RequestMapping(value = "updateOrder",method = RequestMethod.POST)
    public String updateFoods(Order order,Model model){
        service.update(order);
        model.addAttribute("orderList",service.list());

        return "manage";
    }

}
