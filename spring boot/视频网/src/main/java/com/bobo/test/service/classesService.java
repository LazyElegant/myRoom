package com.bobo.test.service;

import com.bobo.test.pojo.classes;

import java.util.List;

public interface classesService {


    public classes listClassesById(Long id);

    public List<classes> listClassesByClassifyId(Long classifyId,Integer page,int limit);

    public int getClassesCount(Long classifyId);

    public  List<classes> getClassesCountByName(String like);
}
