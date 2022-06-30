package com.bobo.test.service;

import com.bobo.test.pojo.science;

import java.util.List;

public interface ScienceService {

    public science queryScienceById(int id);

    public List<science> queryScienceAll();
}
