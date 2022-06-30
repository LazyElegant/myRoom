package com.bobo.test.service;

import com.bobo.test.mapper.classesMapper;
import com.bobo.test.pojo.classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classesServiceImpl implements classesService{

    @Autowired
    classesMapper classesMapper;

    @Override
    public classes listClassesById(Long id) {
        return classesMapper.listClassesById(id);
    }

    @Override
    public List<classes> listClassesByClassifyId(Long classifyId,Integer page,int limit) {
        return classesMapper.listClassesByClassifyId(classifyId,page,limit);
    }

    @Override
    public int getClassesCount(Long classifyId){
        int classesCount = classesMapper.getClassesCount(classifyId);
        return classesCount / 9 +1;
    }

    @Override
    public  List<classes> getClassesCountByName(String like) {
        return classesMapper.getClassesCountByName(like);
    }
}
