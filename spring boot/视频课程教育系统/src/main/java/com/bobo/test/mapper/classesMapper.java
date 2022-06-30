package com.bobo.test.mapper;

import com.bobo.test.pojo.classes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface classesMapper {


    public classes listClassesById(Long id);

    public List<classes> listClassesBySpecialtyId(Long specialtyId);

    public List<classes> pageClassesBySpecialtyId(Long specialtyId,Integer page,Integer limit);

    public int getClassesCount(Long specialtyId);

    public List<classes> getClassesCountByName(String like);

    public int deleteClass(Long id);

    public int addClass(classes classes);

    public int updateClass(classes classes);
}
