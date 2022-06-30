package com.bobo.test.service;

import com.bobo.test.mapper.VideoMapper;
import com.bobo.test.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    VideoMapper videoMapper;

    @Override
    public Video getVideoById(Long id) {
        return videoMapper.getVideoById(id);
    }

    @Override
    public List<Video> getVideoByClassesId(Long classesId) {
        return videoMapper.getVideoByClassesId(classesId);
    }

    @Override
    public int deleteVideo(Long id) {
        return videoMapper.deleteVideo(id);
    }

    @Override
    public int addVideo(Video video) {
        return videoMapper.addVideo(video);
    }

    @Override
    public int updateVideo(int courseware,Long id) {
        return videoMapper.updateVideo(courseware,id);
    }
}
