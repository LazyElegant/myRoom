package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.mapper.CollectMapper;
import com.bobo.test.pojo.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectService {

    @Autowired
    CollectMapper mapper;

    public int insert(Collect collect){
        return mapper.insert(collect);
    }

    public Integer getCollect(Integer ikonId){
        return mapper.getCollect(Tool.getUserID(), ikonId);
    }

    public int unCollect(Integer id){
        return mapper.unCollect(id);
    }
}
