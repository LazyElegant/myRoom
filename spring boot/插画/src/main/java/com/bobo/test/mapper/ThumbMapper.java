package com.bobo.test.mapper;

import com.bobo.test.pojo.Thumb;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ThumbMapper {

    int insert(Thumb thumb);

    Integer getThumb(Integer userId,Integer ikonId);

    int unThumb(Integer id);
}
