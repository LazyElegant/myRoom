package com.bobo.test.mapper;

import com.bobo.test.dto.IkonDto;
import com.bobo.test.vo.IkonVOByAdmin;
import com.bobo.test.vo.IkonVo;
import com.bobo.test.vo.ListIkonByAuthorVo;
import com.bobo.test.vo.ListIkonVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IkonMapper {

    int insertIkon(IkonDto ikon);

    List<ListIkonVo> listIkon();

    List<ListIkonVo> listIkonByCollect(Integer id);

    List<ListIkonVo> listIkonByClassify(Integer id);

    List<ListIkonVo> listIkonByConcern(Integer id);

    List<ListIkonVo> likeIkon(String title);

    IkonVo getIkon(Integer id);

    List<ListIkonByAuthorVo> listIkonByAuthor(Integer authorId);

    int deleteIkon(Integer id);

    List<IkonVOByAdmin> listIkonVo();
}
