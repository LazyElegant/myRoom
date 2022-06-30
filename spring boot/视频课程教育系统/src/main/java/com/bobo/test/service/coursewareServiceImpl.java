package com.bobo.test.service;

import com.bobo.test.mapper.coursewareMapper;
import com.bobo.test.pojo.courseware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author admin
 * @create 2021/5/2 14:05
 */

@Service
public class coursewareServiceImpl implements coursewareService{
    @Autowired
    coursewareMapper coursewareMapper;

    @Override
    public int addCourseware(courseware courseware) {
        return coursewareMapper.addCourseware(courseware);
    }

    @Override
    public String getCourseware(Long id) {
        return coursewareMapper.getCourseware(id);
    }
}
