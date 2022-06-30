package com.bobo.test.service;

import com.bobo.test.dto.ActionDTO;
import com.bobo.test.dto.ProjectDTO;
import com.bobo.test.mapper.ActionMapper;
import com.bobo.test.mapper.DepartmentMapper;
import com.bobo.test.mapper.ProjectMapper;
import com.bobo.test.pojo.Department;
import com.bobo.test.pojo.Project;
import com.bobo.test.util.IDUtil;
import com.bobo.test.vo.CountDepartmentVO;
import com.bobo.test.vo.ProjectVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author admin
 * @create 2021/9/8 20:59
 */
@Service
public class ProjectService {

    @Resource
    private ProjectMapper mapper;
    @Resource
    private ActionMapper aMapper;

    public int insert(ProjectDTO dto){
        dto.setId(IDUtil.getID());
        LocalDateTime now = LocalDateTime.now();
        dto.setCreatTime(now);
        int i = mapper.insertProject(dto);
        aMapper.insertAction(ActionDTO.builder()
                .id(IDUtil.getID())
                .projectId(dto.getId())
                .conductor(dto.getSubmitterId())
                .creatTime(now)
                .rate(0).build());
        return i;
    }

    public List<ProjectVO> list(){
        return mapper.listProject();
    }

    public List<ProjectVO> backlog(Integer department){
        return mapper.backlog(department);
    }

    public int sendBacklog(Long id){
        return mapper.sendBacklog(id);
    }

    public List<CountDepartmentVO> countDepartment(Integer departmentId){
        return mapper.countDepartment(departmentId);
    }

    public int passBacklog(Long id){
        return mapper.passBacklog(id);
    }

    public int acceptProject(Long id){
        return mapper.acceptProject(id);
    }


    public int actionProject(Long id){
        return mapper.actionProject(id);
    }
}
