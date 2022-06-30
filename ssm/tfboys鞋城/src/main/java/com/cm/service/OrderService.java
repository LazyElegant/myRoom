package com.cm.service;

import com.cm.dao.AddressDao;
import com.cm.dao.OrderDao;
import com.cm.dao.ShoppingDao;
import com.cm.model.Order;
import com.cm.util.Tool;
import com.cm.vo.OrderVo;
import com.cm.vo.ShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author admin
 * @create 2022/5/21 23:27
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderDao dao;
    @Autowired
    private ShoppingDao sDao;
    @Autowired
    private AddressDao aDao;

    public int insert(Order order){
        ShoppingVo shoppingVo = sDao.selectMoney(order.getShoppingId());
        order.setId(Tool.getID());
        order.setBuyerId(Tool.getUserID());
        order.setRegistrationDate(LocalDateTime.now());
        order.setAmount(shoppingVo.getAmount());
        order.setSize(shoppingVo.getSize());
        order.setSum(shoppingVo.getMoney() * shoppingVo.getAmount());
        order.setStatus(0);
        order.setAddressId(aDao.select(Tool.getUserID()));
        return dao.insert(order);
    }

    public List<OrderVo> list(Integer id){
        return dao.list(id);
    }

    public List<OrderVo> listAdminOrder(Integer id){
        return dao.listAdminOrder(id);
    }
    public int refund(Integer id,Integer status){
        return dao.updateStatus(id, status);
    }
}
