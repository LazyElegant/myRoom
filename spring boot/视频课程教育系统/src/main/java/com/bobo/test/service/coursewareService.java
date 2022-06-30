package com.bobo.test.service;

import com.bobo.test.pojo.courseware;

/**
 * @Author admin
 * @create 2021/5/2 14:05
 */
public interface coursewareService {

    public int addCourseware(courseware courseware);

    public String getCourseware(Long id);
}
