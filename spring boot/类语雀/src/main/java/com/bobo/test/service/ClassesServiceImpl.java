package com.bobo.test.service;

import com.bobo.test.mapper.ClassesMapper;
import com.bobo.test.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    ClassesMapper classesMapper;

    @Override
    public int addClasses(Classes classes) {
        return classesMapper.addClasses(classes);
    }

    @Override
    public Collection<Classes> queryAllClasses() {
        return classesMapper.queryAllClasses();
    }

    @Override
    public int deleteClasses(String ify_num) {
        return classesMapper.deleteClasses(ify_num);
    }

    @Override
    public int updaleClasses(Classes classes) {
        return classesMapper.updaleClasses(classes);
    }
}
