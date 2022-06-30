package com.bobo.test.service;

import com.bobo.test.dto.LoginDTO;
import com.bobo.test.mapper.DepartmentMapper;
import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.Department;
import com.bobo.test.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author admin
 * @create 2021/9/8 0:55
 */
@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper mapper;

    public List<Department> listDepartment(){
        return mapper.listDepartment();
    }

}
