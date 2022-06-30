package com.bobo.test.mapper;

import com.bobo.test.pojo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyMapper {
    public int addReply(Reply reply);

    public List<Reply> listReplyByCommentId(Long id);

    public List<Reply> listReply();

    public int deleteReply(Long id);

    public int deleteReplyByCommentId(Long id);
}
