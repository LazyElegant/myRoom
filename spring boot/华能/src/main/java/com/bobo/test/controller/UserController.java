package com.bobo.test.controller;

import com.bobo.test.dto.LoginDTO;
import com.bobo.test.dto.RegisterDTO;
import com.bobo.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author admin
 * @create 2021/9/4 14:41
 */
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private final UserService service;

    @PostMapping("/login")
    public Object login(@RequestBody LoginDTO dto) {
        System.out.println(dto);
        return service.login(dto);
    }

    @PostMapping("/register")
    public Object register(@RequestBody RegisterDTO registerDTO){
        return service.register(registerDTO);
    }
}
