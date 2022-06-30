package com.bobo.test.mapper;

import com.bobo.test.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author admin
 * @create 2021/9/8 0:51
 */
@Repository
@Mapper
public interface DepartmentMapper {

    public List<Department> listDepartment();
}
