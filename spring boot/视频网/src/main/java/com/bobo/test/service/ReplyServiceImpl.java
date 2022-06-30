package com.bobo.test.service;

import com.bobo.test.mapper.ReplyMapper;
import com.bobo.test.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    @Override
    public List<Reply> listReplyByCommentId(Long id) {
        return replyMapper.listReplyByCommentId(id);
    }

    @Override
    public List<Reply> listReply() {
        return replyMapper.listReply();
    }

    @Override
    public int deleteReply(Long id) {
        return replyMapper.deleteReply(id);
    }

    @Override
    public int deleteReplyByCommentId(Long id) {
        return replyMapper.deleteReplyByCommentId(id);
    }
}