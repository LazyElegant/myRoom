package com.cm.controller;

import com.cm.model.Goods;
import com.cm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author admin
 * @create 2022/5/25 11:02
 */
@Controller
public class goodsController {

    @Autowired
    private GoodsService service;

    /**
     * 跳转到添加商品页
     * @return
     */
    @RequestMapping("toAddGoods")
    public String toAddGoods(){
        return "addGoods";
    }

    /**
     * 跳转到修改商品页
     * @return
     */
    @RequestMapping("toUpdateGoods")
    public String toUpdateGoods(Integer id ,Model model){
        model.addAttribute("goods",service.get(id));
        return "updateGoods";
    }

    /**
     * 跳转到index
     * @return
     */
    @RequestMapping("index")
    public String toIndex(Model model){
        model.addAttribute("goodsList",service.list());
        return "index";
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping("insertGoods")
    public String insertGoods(Goods goods,Model model){
        service.insert(goods);
        model.addAttribute("goodsList",service.list());
        return "index";
    }

    /**
     * 通过商品名查询
     * @return
     */
    @RequestMapping("getGoods")
    public String insertGoods(String name,Model model){
        model.addAttribute("goodsList",service.get(name));
        return "index";
    }

    /**
     * 跳转到管理页
     * @return
     */
    @RequestMapping("manage")
    public String manage(Model model){
        model.addAttribute("goodsList",service.list());
        return "manage";
    }

    /**
     * 删除商品
     * @return
     */
    @RequestMapping("deleteGoods")
    public String deleteGoods(Integer id,Model model){
        service.delete(id);
        model.addAttribute("goodsList",service.list());
        return "manage";
    }

    /**
     * 修改商品
     * @return
     */
    @RequestMapping(value = "updateGoods",method = RequestMethod.POST)
    public String updateGoods(Goods goods,Model model){
        service.update(goods);
        model.addAttribute("goodsList",service.list());

        return "manage";
    }

}
