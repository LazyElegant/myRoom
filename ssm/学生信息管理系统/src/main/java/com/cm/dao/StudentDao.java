package com.cm.dao;

import com.cm.model.Student;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/24 11:17
 */
public interface StudentDao {

    int insert(Student student);

    List<Student> list();

    Student get(Integer id);

    int update(Student student);

    int delete(Integer id);
}
