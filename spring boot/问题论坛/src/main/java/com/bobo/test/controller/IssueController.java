package com.bobo.test.controller;

import com.bobo.test.config.Tool;
import com.bobo.test.pojo.Issue;
import com.bobo.test.pojo.Review;
import com.bobo.test.service.IssueService;
import com.bobo.test.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IssueController {

    @Autowired
    IssueService service;
    @Autowired
    ReviewService rService;

    @RequestMapping("/postIssue")
    public String postIkon(){
        return "postIssue";
    }

    @RequestMapping("/insertIssue")
    public String insertIssue(Issue issue){
        service.insertIssue(issue);
        return "postIssue";
    }

    @RequestMapping("/issue")
    public String getIssue(Integer id,Model model){
        model.addAttribute("issue",service.getIssue(id));
        model.addAttribute("review",rService.listReview(id));
        return "Issue";
    }

    @RequestMapping("/issueManage")
    public String ikonManage(Model model){
        model.addAttribute("issues",service.listIssueByAuthor(Tool.getUserID()));
        return "issueManage";
    }

    @RequestMapping("/adminIssueManage")
    public String adminIssueManage(Model model){
        model.addAttribute("issues",service.listIssue());
        return "issueManage";
    }


    @RequestMapping("/deleteIssue")
    public String deleteIssue(Integer id){
        service.delete(id);
        return "redirect:/issueManage";
    }

    @RequestMapping("/toModifyIssue")
    public String toModifyIssue(Integer id,Model model){
        model.addAttribute("issue",service.getIssue(id));
        return "ModIssue";
    }

    @RequestMapping("/ModifyIssue")
    public String ModifyIssue(Issue issue){
        service.update(issue);
        return "redirect:/issueManage";
    }

    @RequestMapping("insertReview")
    public String Review(Review review){
        rService.insertReview(review);
        return "redirect:/issue?id=" + review.getIssueId();
    }
}
