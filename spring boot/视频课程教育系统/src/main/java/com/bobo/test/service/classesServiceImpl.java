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
    public List<classes> listClassesBySpecialtyId(Long specialtyId) {
        return classesMapper.listClassesBySpecialtyId(specialtyId);
    }

    @Override
    public List<classes> pageClassesBySpecialtyId(Long specialtyId, int page, int limit) {
        return classesMapper.pageClassesBySpecialtyId(specialtyId,page,limit);
    }

    @Override
    public  List<classes> getClassesCountByName(String like) {
        return classesMapper.getClassesCountByName(like);
    }

    @Override
    public int getClassesCount(Long specialtyId) {
        return classesMapper.getClassesCount(specialtyId)/9;
    }

    @Override
    public int deleteClass(Long id) {
        return classesMapper.deleteClass(id);
    }

    @Override
    public int addClass(classes classes) {
        return classesMapper.addClass(classes);
    }

    @Override
    public int updateClass(classes classes) {
        return classesMapper.updateClass(classes);
    }
}
