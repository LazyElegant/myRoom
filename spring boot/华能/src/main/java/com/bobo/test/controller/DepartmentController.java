package com.bobo.test.controller;

import com.bobo.test.dto.LoginDTO;
import com.bobo.test.service.DepartmentService;
import com.bobo.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author admin
 * @create 2021/9/8 0:57
 */
@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private final DepartmentService service;

    @GetMapping("/list")
    public Object list() {
        return service.listDepartment();
    }

}
