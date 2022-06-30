package com.cm.dao;

import com.cm.dto.GoodsDto;
import com.cm.dto.UpdateGoodsDto;
import com.cm.vo.GoodsVo;
import com.cm.vo.IndexGoodsVo;
import com.cm.vo.UpdateGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/20 20:59
 */
public interface GoodsDao {

    int insertGoods(GoodsDto goods);

    List<GoodsVo> listGoods(Integer id);

    List<IndexGoodsVo> listIndexGoods();

    List<IndexGoodsVo> listAllGoods(@Param("page") Integer page, @Param("limit") Integer limit);

    Integer getAllGoodsNum();

    Integer getGoodsNum(Integer id);

    List<IndexGoodsVo> listGoodsByClass(@Param("id") Integer id,@Param("page") Integer page, @Param("limit") Integer limit);

    UpdateGoodsVo getGoods(Integer id);

    int deleteGoods(Integer id);

    int updateGoods(UpdateGoodsDto dto);
}
