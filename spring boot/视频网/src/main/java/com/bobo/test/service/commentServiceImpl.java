package com.bobo.test.service;

import com.bobo.test.mapper.commentMapper;
import com.bobo.test.pojo.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentServiceImpl implements commentService{

    @Autowired
    commentMapper commentMapper;
    @Override
    public List<comment> queryCommentById(Long id) {
        return commentMapper.queryCommentById(id);
    }

    @Override
    public int addComment(comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int deleteComment(Long id) {
        return commentMapper.deleteComment(id);
    }
}
