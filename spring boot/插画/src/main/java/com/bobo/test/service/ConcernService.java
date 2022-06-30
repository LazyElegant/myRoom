package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.mapper.ConcernMapper;
import com.bobo.test.pojo.Concern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcernService {

    @Autowired
    ConcernMapper mapper;

    public int insert(Concern concern){
        return mapper.insert(concern);
    }

    public Integer getConcern(Integer ikonId){
        return mapper.getConcern(Tool.getUserID(), ikonId);
    }

    public int unConcern(Integer id){
        return mapper.unConcern(id);
    }
}
