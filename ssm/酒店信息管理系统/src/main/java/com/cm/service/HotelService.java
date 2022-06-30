package com.cm.service;

import com.cm.dao.HotelDao;
import com.cm.model.Hotel;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelDao dao;

    public int insert(Hotel hotel){
        hotel.setId(Tool.getID());
        return dao.insert(hotel);
    }

    public List<Hotel> list(){
        return dao.list();
    }

    public List<Hotel> get(String name){
        return dao.get(name);
    }

    public Hotel getById(Integer id){
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


    public int update(Hotel hotel){
        return dao.update(hotel);
    }
}
