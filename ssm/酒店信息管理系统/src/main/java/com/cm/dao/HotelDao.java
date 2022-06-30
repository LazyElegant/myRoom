package com.cm.dao;

import com.cm.model.Hotel;

import java.util.List;

public interface HotelDao {

    /**
     * 插入酒店信息
     * @param
     * @return
     */
    int insert(Hotel hotel);

    /**
     * 返回全部酒店信息
     * @return
     */
    List<Hotel> list();

    /**
     * 通过酒店名获得
     * @param name
     * @return
     */
    List<Hotel> get(String name);

    Hotel getById(Integer id);
    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改快递信息
     * @param hotel
     * @return
     */
    int update(Hotel hotel);
}
