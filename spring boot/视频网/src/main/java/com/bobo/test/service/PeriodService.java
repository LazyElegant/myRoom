package com.bobo.test.service;

import com.bobo.test.pojo.Period;

import java.util.List;

public interface PeriodService {
    public int addPeriod(Period period);
    public List<Period> getPeriod(Long id);
}
