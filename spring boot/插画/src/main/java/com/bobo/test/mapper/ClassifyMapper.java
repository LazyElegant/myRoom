package com.bobo.test.mapper;

import com.bobo.test.pojo.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClassifyMapper {

    int insertClassify(Classify classify);

    List<Classify> list();

    int update(Integer id,String name);
}
