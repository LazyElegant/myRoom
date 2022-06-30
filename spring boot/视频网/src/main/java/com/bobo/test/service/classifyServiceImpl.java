package com.bobo.test.service;

import com.bobo.test.mapper.classifyMapper;
import com.bobo.test.pojo.classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classifyServiceImpl implements classifyService{


    @Autowired
    classifyMapper classifyMapper;

    @Override
    public List<classify> listClassify() {
        return classifyMapper.listClassify();
    }
}
