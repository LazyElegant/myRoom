package com.bobo.test.service;

import com.bobo.test.pojo.Video;

import java.util.List;


public interface VideoService {

    public Video getVideoById(Long id);

    public List<Video> getVideoByClassesId(Long classesId);
}
