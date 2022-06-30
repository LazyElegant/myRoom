package com.cm.dao;

import com.cm.model.Order;
import com.cm.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/21 23:24
 */
public interface OrderDao {

    int insert(Order order);

    List<OrderVo> list(Integer id);

    List<OrderVo> listAdminOrder(Integer id);

    int updateStatus(@Param("id")Integer id,@Param("status") Integer status);
}
