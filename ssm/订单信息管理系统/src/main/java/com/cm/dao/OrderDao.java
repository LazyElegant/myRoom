package com.cm.dao;

import com.cm.model.Order;

import java.util.List;

public interface OrderDao {

    /**
     * 插入订单信息
     * @param order
     * @return
     */
    int insert(Order order);

    /**
     * 返回全部订单
     * @return
     */
    List<Order> list();

    /**
     * 通过name获得
     * @param name
     * @return
     */
    List<Order> get(String name);


    /**
     * 通过id获得
     * @param id
     * @return
     */
    Order getById(Integer id);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改order
     * @param order
     * @return
     */
    int update(Order order);
}
