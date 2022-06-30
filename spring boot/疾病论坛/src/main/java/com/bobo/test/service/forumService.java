package com.bobo.test.service;

import com.bobo.test.pojo.forum;

import java.util.List;

public interface forumService {

    public forum queryForumById(int id);

    public List<forum> queryForumByUserId(int id);

    public List<forum> queryForumAll();

    public int addForum(forum forum);

    public int deleteForum(int id);
}
