package com.bobo.test.mapper;

import com.bobo.test.pojo.Period;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PeriodMapper {
    public int addPeriod(Period period);

    public List<Period> getPeriod(Long id);
}
