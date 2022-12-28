package com.cm.controller;

import com.cm.model.Student;
import com.cm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author admin
 * @create 2022/5/24 11:16
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    /**
     * 前往student页面
     * @return
     */
    @RequestMapping("/toStudent")
    public String toStudent(){
        return "student";
    }

    /**
     * 添加学生信息
     * @return
     */
    @RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
    public String addStudent(Student student,Model model){
        service.insert(student);
        model.addAttribute("list",service.list());
        return "index";
    }
    @RequestMapping("/toindex")
    public String toindex(Model model){
        model.addAttribute("list",service.list());     // 登录成功返回student信息
        return "index";
    }


    /**
     * 前往修改student页面
     * @return
     */
    @RequestMapping("/toUpdateStudent")
    public String toUpdateStudent(Integer id,Model model){
        model.addAttribute("student",service.get(id));
        return "updateStudent";
    }

    /**
     * 修改student
     * @return
     */

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student,Integer id,Model model){
        student.setId(id);
        service.update(student);
        model.addAttribute("list",service.list());
        return "index";
    }

    /**
     * 删除student
     * @return
     */
    @RequestMapping("/deleteStudent")
    public String deleteStudent(Integer id,Model model){
        service.delete(id);
        model.addAttribute("list",service.list());
        return "index";
    }
}
