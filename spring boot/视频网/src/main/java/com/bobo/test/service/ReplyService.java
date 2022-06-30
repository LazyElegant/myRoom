package com.bobo.test.service;

import com.bobo.test.pojo.Reply;

import java.util.List;

public interface ReplyService {
    public int addReply(Reply reply);

    public List<Reply> listReplyByCommentId(Long id);

    public List<Reply> listReply();

    public int deleteReply(Long id);

    public int deleteReplyByCommentId(Long id);
}