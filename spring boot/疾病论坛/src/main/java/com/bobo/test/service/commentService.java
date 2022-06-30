package com.bobo.test.service;

import com.bobo.test.pojo.comment;

import java.util.List;

public interface commentService {

    public List<comment> queryCommentById(int id);

    public int addComment(comment comment);

    public int deleteComment(int id);

}
