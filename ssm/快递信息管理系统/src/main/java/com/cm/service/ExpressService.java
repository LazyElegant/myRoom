package com.cm.service;

import com.cm.dao.ExpressDao;
import com.cm.model.Express;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressService {

    @Autowired
    private ExpressDao dao;

    public int insert(Express express){
        express.setId(Tool.getID());
        express.setStatus(1);
        return dao.insert(express);
    }

    public List<Express> list(){
        return dao.list();
    }

    public List<Express> get(Long numbers){
        return dao.get(numbers);
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
    public int update(Integer id){
        return dao.update(id);
    }
}
