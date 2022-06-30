package com.cm.controller;

import com.cm.model.Foods;
import com.cm.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodsController {

    @Autowired
    private FoodsService service;

    /**
     * 跳转到添加食材页
     * @return
     */
    @RequestMapping("toAddFoods")
    public String toAddFoods(){
        return "addFoods";
    }

    /**
     * 跳转到修改食材页
     * @return
     */
    @RequestMapping("toUpdateFoods")
    public String toUpdateFoods(Integer id ,Model model){
        model.addAttribute("foods",service.get(id));
        return "updateFoods";
    }

    /**
     * 跳转到index
     * @return
     */
    @RequestMapping("index")
    public String toIndex(Model model){
        model.addAttribute("foodsList",service.list());
        return "index";
    }

    /**
     * 添加食材
     * @return
     */
    @RequestMapping("insertFoods")
    public String insertFoods(Foods foods, Model model){
        service.insert(foods);
        model.addAttribute("foodsList",service.list());
        return "index";
    }

    /**
     * 通过食材名查询
     * @return
     */
    @RequestMapping("getFoods")
    public String getFoods(String name,Model model){
        model.addAttribute("foodsList",service.get(name));
        return "index";
    }

    /**
     * 跳转到管理页
     * @return
     */
    @RequestMapping("manage")
    public String manage(Model model){
        model.addAttribute("foodsList",service.list());
        return "manage";
    }

    /**
     * 删除食材
     * @return
     */
    @RequestMapping("deleteFoods")
    public String deleteFoods(Integer id,Model model){
        service.delete(id);
        model.addAttribute("foodsList",service.list());
        return "manage";
    }

    /**
     * 删除食材
     * @return
     */
    @RequestMapping("deleteFoodsList")
    public String deleteFoodsList(String ids,Model model){
        service.deleteList(ids);
        model.addAttribute("foodsList",service.list());
        return "manage";
    }

    /**
     * 修改食材
     * @return
     */
    @RequestMapping(value = "updateFoods",method = RequestMethod.POST)
    public String updateFoods(Foods foods,Model model){
        service.update(foods);
        model.addAttribute("foodsList",service.list());

        return "manage";
    }

}
