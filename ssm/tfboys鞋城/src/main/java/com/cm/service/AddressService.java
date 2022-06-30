package com.cm.service;

import com.cm.dao.AddressDao;
import com.cm.model.Address;
import com.cm.model.Classify;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/19 23:09
 */
@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressDao dao;

    public List<Address> list(Integer id){
        return dao.listAddress(id);
    }

    public int insert(Address address){
        address.setId(Tool.getID());
        address.setUserId(Tool.getUserID());
        address.setStatus(0);
        return dao.insertAddress(address);
    }

    public int delete(Integer id){
        return dao.deleteAddress(id);
    }

    public int update(Integer id,Integer status){
        dao.updateStatus(Tool.getUserID());
        System.out.println(status==1);
        if (status==1) {
            dao.selectStatus(id);
        }
        return 1;
    }

    public Integer get(){
        return dao.select(Tool.getUserID());
    }
}
