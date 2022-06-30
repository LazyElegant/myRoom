package com.bobo.test.mapper;

import com.bobo.test.pojo.book;
import com.bobo.test.pojo.science;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ScienceMapper {

    public science queryScienceById(int id);

    public List<science> queryScienceAll();

}
