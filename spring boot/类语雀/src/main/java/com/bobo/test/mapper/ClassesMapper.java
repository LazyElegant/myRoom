package com.bobo.test.mapper;


import com.bobo.test.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface ClassesMapper {

    public int addClasses(Classes classes);

    public Collection<Classes> queryAllClasses();

    public int deleteClasses(String ify_num);

    public int updaleClasses(Classes classes);
}
