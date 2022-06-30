package com.bobo.test.service;

import com.bobo.test.mapper.specialtyMapper;
import com.bobo.test.pojo.specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class specialtyServiceImpl implements specialtyService {

    @Autowired
    specialtyMapper specialtyMapper;

    @Override
    public List<specialty> querySpecialty() {
        return specialtyMapper.querySpecialty();
    }

    @Override
    public specialty querySpecialtyById(Long id) {
        return specialtyMapper.querySpecialtyById(id);
    }
}
