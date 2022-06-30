package com.cm.dao;

import com.cm.model.Express;

import java.util.List;

public interface ExpressDao {

    /**
     * 插入快递信息
     * @param
     * @return
     */
    int insert(Express express);

    /**
     * 返回全部快递信息
     * @return
     */
    List<Express> list();

    /**
     * 通过快递单号获得
     * @param numbers
     * @return
     */
    List<Express> get(Long numbers);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改快递信息
     * @param id
     * @return
     */
    int update(Integer id);
}
