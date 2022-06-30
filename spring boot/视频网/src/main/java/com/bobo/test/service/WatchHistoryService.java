package com.bobo.test.service;

import com.bobo.test.pojo.WatchHistory;

import java.util.List;

public interface WatchHistoryService {

    public List<WatchHistory> getWatchHistoryByUserId(Long userId);

    public int insertWatchHistory(WatchHistory watchHistory);

    public int deleteHistory(Long userId);

    public List<WatchHistory> getWatchHistoryById(Long userId,Long videoId);
}
