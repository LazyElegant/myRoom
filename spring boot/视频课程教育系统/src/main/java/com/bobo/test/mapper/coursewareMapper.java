package com.bobo.test.mapper;

import com.bobo.test.pojo.courseware;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author admin
 * @create 2021/5/2 14:02
 */

@Repository
@Mapper
public interface coursewareMapper {

    public int addCourseware(courseware courseware);

    public String getCourseware(Long id);
}
