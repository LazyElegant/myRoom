package com.bobo.test.service;

import com.bobo.test.mapper.BookMapper;
import com.bobo.test.mapper.ScienceMapper;
import com.bobo.test.pojo.science;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScienceServiceImpl implements ScienceService{

    @Autowired
    ScienceMapper scienceMapper;

    @Override
    public science queryScienceById(int id) {
        return scienceMapper.queryScienceById(id);
    }

    @Override
    public List<science> queryScienceAll() {
        return scienceMapper.queryScienceAll();
    }
}
