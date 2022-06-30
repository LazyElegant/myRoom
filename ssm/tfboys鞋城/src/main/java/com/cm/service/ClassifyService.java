package com.cm.service;

import com.cm.dao.ClassifyDao;
import com.cm.model.Classify;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/19 10:23
 */
@Service
@Transactional
public class ClassifyService {

    @Autowired
    private ClassifyDao dao;

    public List<Classify> list(){
        return dao.listClassify();
    }

    public int add(String name){
        return dao.insert(new Classify(Tool.getID(),name));
    }

    public int delete(Integer id){
        return dao.delete(id);
    }

    public int update(Classify classify){
        return dao.update(classify);
    }

}
