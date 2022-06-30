package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.dto.IkonDto;
import com.bobo.test.pojo.*;
import com.bobo.test.service.*;
import com.bobo.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class IkonController {

    @Autowired
    IkonService iService;
    @Autowired
    ReviewService rService;
    @Autowired
    ThumbService tService;
    @Autowired
    CollectService cService;
    @Autowired
    ConcernService conService;

    @RequestMapping("/postIkon")
    public String postIkon(){
        return "postIkon";
    }

    @PostMapping("/insertIkon")
    public String insertIkon(IkonDto dto){
        iService.insertIkon(dto);
        return "postIkon";
    }

    @RequestMapping("/Ikon")
    public String Ikon(Integer id, Model model){
        model.addAttribute("ikon",iService.get(id));
        model.addAttribute("review",rService.listByIkonId(id));
        model.addAttribute("thumb",tService.getThumb(id));
        model.addAttribute("collect",cService.getCollect(id));
        model.addAttribute("concern",conService.getConcern(id));
        return "Ikon";
    }

    @PostMapping("/review")
    public String review(Integer ikonId,String context){
        rService.insertReview(new Review(Tool.getID(),Tool.getUserID(),ikonId,context, LocalDateTime.now()));
        return "redirect:/Ikon?id=" + ikonId;
    }

    @RequestMapping("/Ikon/thumb")
    public String thumb(Integer id){
        tService.insert(new Thumb(Tool.getID(),Tool.getUserID(),id,LocalDateTime.now()));
        return "redirect:/Ikon?id=" + id;
    }

    @RequestMapping("/Ikon/unThumb")
    public String unThumb(Integer id,Integer ikonId){
        tService.unThumb(id);
        return "redirect:/Ikon?id=" + ikonId;
    }

    @RequestMapping("/Ikon/collect")
    public String collect(Integer id){
        cService.insert(new Collect(Tool.getID(),Tool.getUserID(),id,LocalDateTime.now()));
        return "redirect:/Ikon?id=" + id;
    }

    @RequestMapping("/Ikon/unCollect")
    public String unCollect(Integer id,Integer ikonId){
        cService.unCollect(id);
        return "redirect:/Ikon?id=" + ikonId;
    }


    @RequestMapping("/Ikon/concern")
    public String concern(Integer id,Integer ikonId){
        conService.insert(new Concern(Tool.getID(),Tool.getUserID(),id,LocalDateTime.now()));
        return "redirect:/Ikon?id=" + ikonId;
    }

    @RequestMapping("/Ikon/unConcern")
    public String unConcern(Integer id,Integer ikonId){
        conService.unConcern(id);
        return "redirect:/Ikon?id=" + ikonId;
    }

    @RequestMapping("/ikonManage")
    public String ikonManage(Model model){
        model.addAttribute("ikons",iService.listIkonByAuthor(Tool.getUserID()));
        return "ikonManage";
    }

    @RequestMapping("/adminIkonManage")
    public String adminIkonManage(Model model){
        model.addAttribute("ikons",iService.listIkonVOByAdmin());
        return "adminIkonManage";
    }

    @RequestMapping("/deleteIkon")
    public String deleteIkon(Integer id){
        iService.deleteIkon(id);
        return "redirect:/ikonManage";
    }

    @RequestMapping("/adminDeleteIkon")
    public String adminDeleteIkon(Integer id){
        iService.deleteIkon(id);
        return "redirect:/";
    }
}
