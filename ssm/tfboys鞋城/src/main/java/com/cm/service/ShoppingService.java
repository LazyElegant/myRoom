package com.cm.service;

import com.cm.dao.ShoppingDao;
import com.cm.dto.ShoppingDto;
import com.cm.model.Shopping;
import com.cm.util.Tool;
import com.cm.vo.ShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author admin
 * @create 2022/5/21 17:46
 */
@Service
@Transactional
public class ShoppingService {
    @Autowired
    private ShoppingDao dao;

    public int insert(Shopping shopping){
        shopping.setId(Tool.getID());
        shopping.setAmount(1);
        shopping.setBuyerId(Tool.getUserID());
        shopping.setRegistrationDate(LocalDateTime.now());
        shopping.setSize(35);
        return dao.insertShopping(shopping);
    }
    public int inserts(Shopping shopping){
        shopping.setId(Tool.getID());
        shopping.setBuyerId(Tool.getUserID());
        shopping.setRegistrationDate(LocalDateTime.now());
        return dao.insertShopping(shopping);
    }

    public List<ShoppingDto> list(Integer id){
        return dao.listShopping(id);
    }

    public int updateAmount(Integer id,Integer amount ){
        return dao.updateAmount(id, amount);
    }
    public int updateSize(Integer id,Integer size ){
        return dao.updateSize(id, size);
    }

    public int delete(Integer id){
        return dao.delete(id);
    }

    public Double SelectMoney(Integer id){
        ShoppingVo shoppingVo = dao.selectMoney(id);
        return shoppingVo.getMoney() * shoppingVo.getAmount();
    }
}
