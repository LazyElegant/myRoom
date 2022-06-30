package com.cm.controller;

import com.cm.dto.UpdateUserDto;
import com.cm.model.Address;
import com.cm.service.AddressService;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author admin
 * @create 2022/5/19 22:55
 */
@Controller
public class AddressController {

    @Autowired
    private AddressService service;

    @RequestMapping("address")
    public String personal(Model model){
        model.addAttribute("address",service.list(Tool.getUserID()));
        return "address";
    }

    @RequestMapping(value = "insertAddress" ,method = RequestMethod.POST)
    @ResponseBody
    public int updateUser(Address address){
        return service.insert(address);
    }

    @RequestMapping("deleteAddress")
    @ResponseBody
    public int deleteAddress(Integer id ){
        return  service.delete(id);
    }

    @RequestMapping("selectAddress")
    @ResponseBody
    public int selectAddress(Integer id,Integer status){
        return  service.update(id,status);
    }
}
