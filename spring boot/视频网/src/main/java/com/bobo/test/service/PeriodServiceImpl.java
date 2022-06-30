package com.bobo.test.service;

import com.bobo.test.mapper.PeriodMapper;
import com.bobo.test.pojo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author admin
 * @create 2021/5/9 17:29
 */
@Service
public class PeriodServiceImpl implements PeriodService{

    @Autowired
    PeriodMapper periodMapper;

    @Override
    public int addPeriod(Period period) {
        return periodMapper.addPeriod(period);
    }

    @Override
    public List<Period> getPeriod(Long id) {
        return periodMapper.getPeriod(id);
    }
}
