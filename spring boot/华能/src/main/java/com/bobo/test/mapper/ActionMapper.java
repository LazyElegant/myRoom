package com.bobo.test.mapper;

import com.bobo.test.dto.ActionDTO;
import com.bobo.test.vo.ProjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author admin
 * @create 2021/9/9 23:59
 */
@Repository
@Mapper
public interface ActionMapper {

    public int insertAction(ActionDTO dto);

    public List<ProjectVO> listAction(Long id);

}
