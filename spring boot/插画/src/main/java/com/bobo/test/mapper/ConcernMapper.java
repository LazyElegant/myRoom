package com.bobo.test.mapper;

import com.bobo.test.pojo.Concern;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ConcernMapper {

    int insert(Concern concern);

    Integer getConcern(Integer userId,Integer ikonId);

    int unConcern(Integer id);
}
