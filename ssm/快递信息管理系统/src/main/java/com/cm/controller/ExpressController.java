package com.cm.controller;

import com.cm.model.Express;
import com.cm.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExpressController {

    @Autowired
    private ExpressService service;

    /**
     * 跳转到添加快递页
     * @return
     */
    @RequestMapping("toAddExpress")
    public String toAddExpress(){
        return "addExpress";
    }

    /**
     * 跳转到index
     * @return
     */
    @RequestMapping("index")
    public String toIndex(Model model){
        model.addAttribute("expressList",service.list());
        return "index";
    }

    /**
     * 添加快递
     * @return
     */
    @RequestMapping("insertExpress")
    public String insertExpress(Express express, Model model){
        System.out.println(express.toString());
        service.insert(express);
        model.addAttribute("expressList",service.list());
        return "index";
    }

    /**
     * 通过快递单号查询
     * @return
     */
    @RequestMapping("getExpress")
    public String getFoods(Long id,Model model){
        model.addAttribute("expressList",service.get(id));
        return "index";
    }

    /**
     * 跳转到管理页
     * @return
     */
    @RequestMapping("manage")
    public String manage(Model model){
        model.addAttribute("expressList",service.list());
        return "manage";
    }

    /**
     * 删除快递信息
     * @return
     */
    @RequestMapping("deleteExpress")
    public String deleteExpress(Integer id,Model model){
        service.delete(id);
        model.addAttribute("expressList",service.list());
        return "manage";
    }

    /**
     * 删除快递
     * @return
     */
    @RequestMapping("deleteExpressList")
    public String deleteExpressList(String ids,Model model){
        service.deleteList(ids);
        model.addAttribute("expressList",service.list());
        return "manage";
    }

    /**
     * 修改快递
     * @return
     */
    @RequestMapping( "updateExpress")
    public String updateExpress(Integer id,Model model){
        service.update(id);
        model.addAttribute("expressList",service.list());
        return "manage";
    }

}
