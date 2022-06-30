package com.bobo.test.mapper;

import com.bobo.test.pojo.forum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface forumMapper {

    public forum queryForumById(int id);

    public List<forum> queryForumByUserId(int id);

    public List<forum> queryForumAll();

    public int addForum(forum forum);

    public int deleteForum(int id);
}
