package com.bobo.test.mapper;

import com.bobo.test.pojo.classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface classifyMapper {

    public List<classify> listClassify();
}
