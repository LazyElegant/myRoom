package com.bobo.test.service;

import com.bobo.test.mapper.forumMapper;
import com.bobo.test.pojo.forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class forumServiceImpl implements forumService{



    @Autowired
    forumMapper forumMapper;

    @Override
    public forum queryForumById(int id) {
        return forumMapper.queryForumById(id);
    }

    @Override
    public List<forum> queryForumByUserId(int id) {
        return forumMapper.queryForumByUserId(id);
    }

    @Override
    public List<forum> queryForumAll() {
        return forumMapper.queryForumAll();
    }

    @Override
    public int addForum(forum forum) {
        return forumMapper.addForum(forum);
    }

    @Override
    public int deleteForum(int id) {
        return forumMapper.deleteForum(id);
    }
}
