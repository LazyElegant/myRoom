package com.bobo.test.mapper;

import com.bobo.test.dto.ProjectDTO;
import com.bobo.test.vo.CountDepartmentVO;
import com.bobo.test.vo.ProjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author admin
 * @create 2021/9/8 20:51
 */
@Repository
@Mapper
public interface ProjectMapper {

    public int insertProject(ProjectDTO dto);

    public List<ProjectVO> listProject();

    public List<ProjectVO> backlog(Integer department);

    public int sendBacklog(Long id);

    public List<CountDepartmentVO> countDepartment(Integer department);

    public int passBacklog(Long id);

    public int acceptProject(Long id);

    public int actionProject(Long id);
}
