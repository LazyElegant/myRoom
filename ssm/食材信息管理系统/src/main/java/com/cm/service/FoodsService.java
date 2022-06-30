package com.cm.service;

import com.cm.dao.FoodsDao;
import com.cm.model.Foods;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodsService {

    @Autowired
    private FoodsDao dao;

    public int insert(Foods foods){
        foods.setId(Tool.getID());
        return dao.insert(foods);
    }

    public List<Foods> list(){
        return dao.list();
    }

    public List<Foods> get(String name){
        return dao.get(name);
    }
    public Foods get(Integer id){
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

    public int update(Foods foods){
        return dao.update(foods);
    }
}
