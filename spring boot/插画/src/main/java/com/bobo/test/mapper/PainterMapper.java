package com.bobo.test.mapper;

import com.bobo.test.pojo.Painter;
import com.bobo.test.vo.PainterVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PainterMapper {

    int insertPainter(Painter painter);

    List<PainterVo> listPainter();

    int updatePainter(Integer status,Integer id);
}
