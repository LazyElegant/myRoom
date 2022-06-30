package com.bobo.test.service;

import com.bobo.test.pojo.Classes;

import java.util.Collection;

public interface ClassesService{

    public int addClasses(Classes classes);

    public Collection<Classes> queryAllClasses();

    public int deleteClasses(String ify_num);

    public int updaleClasses(Classes classes);
}
