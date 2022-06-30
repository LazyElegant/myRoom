package com.bobo.test.controller;

import com.bobo.test.dto.ActionDTO;
import com.bobo.test.dto.ProjectDTO;
import com.bobo.test.service.ActionService;
import com.bobo.test.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author admin
 * @create 2021/9/10 0:24
 */
@AllArgsConstructor
@RestController
@RequestMapping("/action")
public class ActionController {

    @Resource
    private final ActionService service;

    @PostMapping("/insert")
    public Object insert(@RequestBody ActionDTO dto) {
        return service.insert(dto);
    }

    @GetMapping("/list/{id}")
    public Object list(@PathVariable Long id) {
        return service.list(id);
    }
}
