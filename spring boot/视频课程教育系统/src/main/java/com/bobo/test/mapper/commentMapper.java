package com.bobo.test.mapper;

import com.bobo.test.pojo.comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface commentMapper {

    public List<comment> queryCommentById(Long id);

    public int addComment(comment comment);

    public int deleteComment(Long id);
}
