package com.cm.service;

import com.cm.dao.GoodsDao;
import com.cm.dao.UserDao;
import com.cm.model.Goods;
import com.cm.model.User;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/25 11:18
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao dao;

    public int insert(Goods goods){
        goods.setId(Tool.getID());
        return dao.insertGoods(goods);
    }

    public List<Goods> list(){
        return dao.list();
    }

    public List<Goods> get(String name){
        return dao.get(name);
    }
    public Goods get(Integer id){
        return dao.getById(id);
    }

    public int delete(Integer id){
        return dao.delete(id);
    }

    public int update(Goods goods){
        return dao.update(goods);
    }
}
