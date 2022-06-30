package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.mapper.ThumbMapper;
import com.bobo.test.pojo.Thumb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThumbService {
    @Autowired
    ThumbMapper mapper;

    public int insert(Thumb thumb){
        return mapper.insert(thumb);
    }

    public Integer getThumb(Integer ikonId){
        return mapper.getThumb(Tool.getUserID(), ikonId);
    }

    public int unThumb(Integer id){
        return mapper.unThumb(id);
    }
}
