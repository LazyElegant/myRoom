package com.bobo.test.mapper;

import com.bobo.test.pojo.Issue;
import com.bobo.test.vo.IssueVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IssueMapper {

    int insertIssue(Issue issue);

    List<IssueVo> listIssue();

    IssueVo getIssue(Integer id);

    List<IssueVo> listIssueByAuthor(Integer id);

    int deleteIssue(Integer id);

    int update(Issue issue);
}
