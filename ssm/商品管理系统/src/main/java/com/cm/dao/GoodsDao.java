package com.cm.dao;

import com.cm.model.Goods;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/25 11:09
 */
public interface GoodsDao {

    /**
     * 插入商品
     * @param goods
     * @return
     */
    int insertGoods(Goods goods);

    /**
     * 返回全部商品
     * @return
     */
    List<Goods> list();

    /**
     * 通过name获得goods
     * @param name
     * @return
     */
    List<Goods> get(String name);


    /**
     * 通过id获得goods
     * @param id
     * @return
     */
    Goods getById(Integer id);

    /**
     * 通过id删除goods
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改goods
     * @param goods
     * @return
     */
    int update(Goods goods);
}
