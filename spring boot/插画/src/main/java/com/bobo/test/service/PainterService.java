package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.mapper.PainterMapper;
import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.Painter;
import com.bobo.test.vo.PainterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PainterService {

    @Autowired
    PainterMapper pMapper;
    @Autowired
    UserMapper uMapper;

    public int insertPainter(Painter painter){
        painter.setId(Tool.getID());
        painter.setUserId(Tool.getUserID());
        painter.setRegistrationTime(LocalDateTime.now());
        return pMapper.insertPainter(painter);
    }

    public List<PainterVo> listPainter(){
        return pMapper.listPainter();
    }

    public int updatePainter(Integer status,Integer id){
        if (status ==2 ){
            uMapper.updateStatus(uMapper.getUserIdByPainterId(id),2);
        }

        return pMapper.updatePainter(status, id);
    }
}
