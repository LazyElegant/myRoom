package com.cm.dao;

import com.cm.model.Classify;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/18 22:56
 */
public interface ClassifyDao {

    List<Classify> listClassify();

    int insert(Classify classify);

    int delete(Integer id);

    int update(Classify classify);
}
