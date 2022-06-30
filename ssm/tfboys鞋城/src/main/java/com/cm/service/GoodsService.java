package com.cm.service;

import com.cm.dao.GoodsDao;
import com.cm.dto.GoodsDto;
import com.cm.dto.UpdateGoodsDto;
import com.cm.model.Goods;
import com.cm.util.Tool;
import com.cm.vo.GoodsVo;
import com.cm.vo.IndexGoodsVo;
import com.cm.vo.UpdateGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author admin
 * @create 2022/5/20 21:14
 */
@Service
@Transactional
public class GoodsService {
    @Autowired
    private GoodsDao dao;

    public int insert(GoodsDto goods){
        goods.setId(Tool.getID());
        goods.setSellerId(Tool.getUserID());
        goods.setRegistrationDate(LocalDateTime.now());
        goods.setImgUrl(Tool.createPictures(goods.getPictures()));
        return dao.insertGoods(goods);
    }

    public List<GoodsVo> list(Integer id){
        return dao.listGoods(id);
    }

    public UpdateGoodsVo get(Integer id){
        return dao.getGoods(id);
    }

    public List<IndexGoodsVo> listIndex(){
        return dao.listIndexGoods();
    }
    public List<IndexGoodsVo> listAll(Integer page,Integer limit){
        return dao.listAllGoods(page,limit);
    }

    public Integer getAllGoodsNum(){
        return dao.getAllGoodsNum();
    }
    public Integer getGoodsNum(Integer id){
        return dao.getGoodsNum(id);
    }

    public List<IndexGoodsVo> listGoodsByClass(Integer id,Integer page,Integer limit){
        return dao.listGoodsByClass(id,page,limit);
    }
    public int delete(Integer id){
        return dao.deleteGoods(id);
    }

    public int update(UpdateGoodsDto dto){
        return dao.updateGoods(dto);
    }

}
