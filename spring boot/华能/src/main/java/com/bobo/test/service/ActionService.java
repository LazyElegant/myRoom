package com.bobo.test.service;

import com.bobo.test.dto.ActionDTO;
import com.bobo.test.mapper.ActionMapper;
import com.bobo.test.util.IDUtil;
import com.bobo.test.vo.ProjectVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import java.util.List;
/**
 * @Author admin
 * @create 2021/9/10 0:23
 */
@Service
public class ActionService {

    @Resource
    private ActionMapper mapper;

    public int insert(ActionDTO dto){
        dto.setId(IDUtil.getID());
        dto.setCreatTime(LocalDateTime.now());
        return mapper.insertAction(dto);
    }

    public List<ProjectVO> list(Long id){
        return mapper.listAction(id);
    }
}
