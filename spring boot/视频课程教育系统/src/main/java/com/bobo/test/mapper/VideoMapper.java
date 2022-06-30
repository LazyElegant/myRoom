package com.bobo.test.mapper;


import com.bobo.test.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoMapper {

    public Video getVideoById(Long id);

    public List<Video> getVideoByClassesId(Long classesId);

    public int deleteVideo(Long id);

    public int addVideo(Video video);

    public int updateVideo(int courseware,Long id);

}
