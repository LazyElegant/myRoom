package com.bobo.test.controller;

import com.bobo.test.dto.ProjectDTO;
import com.bobo.test.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author admin
 * @create 2021/9/8 21:01
 */
@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private final ProjectService service;

    @PostMapping("/insert")
    public Object insert(@RequestBody ProjectDTO dto) {
        System.out.println(dto.toString());
        return service.insert(dto);
    }

    @GetMapping("/list")
    public Object list(){
        return service.list();
    }

    @GetMapping("/listBacklog/{department}")
    public Object listBacklog(@PathVariable Integer department){
        return service.backlog(department);
    }

    @PostMapping("/sendBacklog/{id}")
    public Object sendBacklog(@PathVariable Long id){
        return service.sendBacklog(id);
    }

    @GetMapping("/countDepartment/{id}")
    public Object countDepartment(@PathVariable Integer id){
        return service.countDepartment(id);
    }

    @PostMapping("/passBacklog/{id}")
    public Object passBacklog(@PathVariable Long id){
        return service.passBacklog(id);
    }

    @PostMapping("/acceptProject/{id}")
    public Object acceptProject(@PathVariable Long id){
        return service.acceptProject(id);
    }

    @PostMapping("/actionProject/{id}")
    public Object actionProject(@PathVariable Long id){
        return service.actionProject(id);
    }
}
