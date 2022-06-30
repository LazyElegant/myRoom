package com.cm.dao;

import com.cm.model.Foods;

import java.util.List;

public interface FoodsDao {

    /**
     * 插入食材信息
     * @param foods
     * @return
     */
    int insert(Foods foods);

    /**
     * 返回全部食材
     * @return
     */
    List<Foods> list();

    /**
     * 通过name获得foods
     * @param name
     * @return
     */
    List<Foods> get(String name);


    /**
     * 通过id获得foods
     * @param id
     * @return
     */
    Foods getById(Integer id);

    /**
     * 通过id删除foods
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改foods
     * @param foods
     * @return
     */
    int update(Foods foods);
}
