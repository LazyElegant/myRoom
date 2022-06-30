package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.dto.IkonDto;
import com.bobo.test.mapper.IkonMapper;
import com.bobo.test.vo.IkonVOByAdmin;
import com.bobo.test.vo.IkonVo;
import com.bobo.test.vo.ListIkonByAuthorVo;
import com.bobo.test.vo.ListIkonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IkonService {

    @Autowired
    IkonMapper mapper;

    public int insertIkon(IkonDto ikon){
        ikon.setId(Tool.getID());
        ikon.setAuthorId(Tool.getUserID());
        ikon.setIssueTime(LocalDateTime.now());
        ikon.setPic(Tool.createPictures(ikon.getPictures()));
        return mapper.insertIkon(ikon);
    }

    public List<ListIkonVo> list(){
        return mapper.listIkon();
    }


    public List<ListIkonVo> listIkonByCollect(){
        return mapper.listIkonByCollect(Tool.getUserID());
    }


    public List<ListIkonVo> listIkonByClassify(Integer id){
        return mapper.listIkonByClassify(id);
    }

    public List<ListIkonVo> listIkonByConcern(){
        return mapper.listIkonByConcern(Tool.getUserID());
    }

    public List<ListIkonVo> likeIkon(String title){
        return mapper.likeIkon(title);
    }

    public IkonVo get(Integer id){
        return mapper.getIkon(id);
    }

    public List<ListIkonByAuthorVo> listIkonByAuthor(Integer id){
        return mapper.listIkonByAuthor(id);
    }

    public int deleteIkon(Integer id){
        return mapper.deleteIkon(id);
    }

    public List<IkonVOByAdmin> listIkonVOByAdmin(){
        return mapper.listIkonVo();
    }
}
