package com.bobo.test.mapper;

import com.bobo.test.pojo.classes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface classesMapper {


    public classes listClassesById(Long id);

    public List<classes> listClassesByClassifyId(Long classifyId,Integer page,int limit);

    public int getClassesCount(Long classifyId);

    public List<classes> getClassesCountByName(String like);
}
