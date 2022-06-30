package com.cm.dao;

import com.cm.dto.ShoppingDto;
import com.cm.model.Shopping;
import com.cm.vo.ShoppingVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author admin
 * @create 2022/5/21 17:43
 */
public interface ShoppingDao {


    int insertShopping(Shopping Shopping);

    List<ShoppingDto> listShopping(Integer id);

    int updateAmount(@Param("id")Integer id,@Param("amount") Integer amount);

    int updateSize(@Param("id")Integer id,@Param("size") Integer size);

    int delete(Integer id);

    ShoppingVo selectMoney(Integer id);
}
