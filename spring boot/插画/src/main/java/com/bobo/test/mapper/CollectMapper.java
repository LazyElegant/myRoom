package com.bobo.test.mapper;

import com.bobo.test.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CollectMapper {
    int insert(Collect collect);
    Integer getCollect(Integer userId,Integer ikonId);
    int unCollect(Integer id);
}
