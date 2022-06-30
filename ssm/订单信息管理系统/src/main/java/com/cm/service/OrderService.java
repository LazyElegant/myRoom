package com.cm.service;

import com.cm.dao.OrderDao;
import com.cm.model.Order;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    public int insert(Order order){
        order.setId(Tool.getID());
        return dao.insert(order);
    }

    public List<Order> list(){
        return dao.list();
    }

    public List<Order> get(String name){
        return dao.get(name);
    }
    public Order getById(Integer id){
        return dao.getById(id);
    }

    public int delete(Integer id){
        return dao.delete(id);
    }
    public void deleteList(String ids){
        String[] split = ids.split(",");
        for (int i1 = 0; i1 < split.length; i1++) {
            dao.delete(Integer.valueOf(split[i1]));
        }
    }

    public int update(Order foods){
        return dao.update(foods);
    }
}
