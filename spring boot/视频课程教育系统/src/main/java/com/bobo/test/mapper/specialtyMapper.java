package com.bobo.test.mapper;

import com.bobo.test.pojo.specialty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface specialtyMapper {

    public List<specialty> querySpecialty();

    public specialty querySpecialtyById(Long id);
}
