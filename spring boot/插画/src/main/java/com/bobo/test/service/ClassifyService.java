package com.bobo.test.service;

import com.bobo.test.mapper.ClassifyMapper;
import com.bobo.test.pojo.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyService {
    @Autowired
    ClassifyMapper mapper;

    public int insertClassify(Classify ify){
        return mapper.insertClassify(ify);
    }

    public List<Classify> list(){
        return mapper.list();
    }
    public int update(Integer id, String name){
        return mapper.update(id, name);
    }
}
