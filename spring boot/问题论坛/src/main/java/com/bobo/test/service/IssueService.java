package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.mapper.IssueMapper;
import com.bobo.test.pojo.Issue;
import com.bobo.test.vo.IssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    IssueMapper mapper;

    public int insertIssue(Issue issue){
        issue.setId(Tool.getID());
        issue.setIssueTime(LocalDateTime.now());
        issue.setAuthorId(Tool.getUserID());
        return mapper.insertIssue(issue);
    }

    public List<IssueVo> listIssue(){
        return mapper.listIssue();
    }

    public IssueVo getIssue(Integer id){
        return mapper.getIssue(id);
    }

    public List<IssueVo> listIssueByAuthor(Integer id){
        return mapper.listIssueByAuthor(id);
    }

    public int delete(Integer id){
        return mapper.deleteIssue(id);
    }

    public int update(Issue issue){
        return mapper.update(issue);
    }
}
