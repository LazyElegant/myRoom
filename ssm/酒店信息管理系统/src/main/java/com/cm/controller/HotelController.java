package com.cm.controller;

import com.cm.model.Hotel;
import com.cm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotelController {

    @Autowired
    private HotelService service;

    /**
     * 跳转到添加酒店页
     * @return
     */
    @RequestMapping("toAddHotel")
    public String toAddHotel(){
        return "addHotel";
    }

    /**
     * 跳转到index
     * @return
     */
    @RequestMapping("index")
    public String toIndex(Model model){
        model.addAttribute("hotelList",service.list());
        return "index";
    }

    /**
     * 添加酒店信息
     * @return
     */
    @RequestMapping("insertHotel")
    public String insertHotel(Hotel hotel, Model model){
        service.insert(hotel);
        model.addAttribute("hotelList",service.list());
        return "index";
    }

    /**
     * 通过酒店名查询
     * @return
     */
    @RequestMapping("getHotel")
    public String getHotel(String name,Model model){
        model.addAttribute("hotelList",service.get(name));
        return "index";
    }

    /**
     * 跳转到管理页
     * @return
     */
    @RequestMapping("manage")
    public String manage(Model model){
        model.addAttribute("hotelList",service.list());
        return "manage";
    }

    /**
     * 删除酒店信息
     * @return
     */
    @RequestMapping("deleteHotel")
    public String deleteHotel(Integer id,Model model){
        service.delete(id);
        model.addAttribute("hotelList",service.list());
        return "manage";
    }

    /**
     * 批量删除酒店信息
     * @return
     */
    @RequestMapping("deleteHotelList")
    public String deleteHotelList(String ids,Model model){
        service.deleteList(ids);
        model.addAttribute("hotelList",service.list());
        return "manage";
    }
    /**
     * 跳转到修改酒店信息页
     * @return
     */
    @RequestMapping("toUpdateHotel")
    public String toUpdateHotel(Integer id ,Model model){
        model.addAttribute("hotel",service.getById(id));
        return "updateHotel";
    }


    /**
     * 修改酒店
     * @return
     */
    @RequestMapping( "updateHotel")
    public String updateHotel(Hotel hotel,Model model){
        service.update(hotel);
        model.addAttribute("hotelList",service.list());
        return "manage";
    }

}
