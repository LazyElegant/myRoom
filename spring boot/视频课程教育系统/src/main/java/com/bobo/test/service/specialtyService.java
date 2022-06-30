package com.bobo.test.service;

import com.bobo.test.pojo.specialty;

import java.util.List;

public interface specialtyService {

    public List<specialty> querySpecialty();

    public specialty querySpecialtyById(Long id);

}
