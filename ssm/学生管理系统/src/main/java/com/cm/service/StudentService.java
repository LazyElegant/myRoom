package com.cm.service;

import com.cm.dao.StudentDao;
import com.cm.model.Student;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/24 11:21
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao dao;

    public int insert(Student student){
        student.setId(Tool.getID());
        return dao.insert(student);
    }

    public List<Student> list(){
        return dao.list();
    }

    public Student get(Integer id){
        return dao.get(id);
    }

    public int update(Student student){
        return dao.update(student);
    }

    public int delete(Integer id){
        return dao.delete(id);
    }
}
