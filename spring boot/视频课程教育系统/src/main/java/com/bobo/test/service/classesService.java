package com.bobo.test.service;

import com.bobo.test.pojo.classes;

import java.util.List;

public interface classesService {


    public classes listClassesById(Long id);

    public List<classes> listClassesBySpecialtyId(Long specialtyId);

    public List<classes> pageClassesBySpecialtyId(Long specialtyId,int page,int limit);

    public  List<classes> getClassesCountByName(String like);

    public int getClassesCount(Long specialtyId);

    public int deleteClass(Long id);

    public int addClass(classes classes);

    public int updateClass(classes classes);
}
