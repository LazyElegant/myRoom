package com.bobo.test.service;

import com.bobo.test.mapper.WatchHistoryMapper;
import com.bobo.test.mapper.classesMapper;
import com.bobo.test.pojo.WatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchHistoryServiceImpl implements WatchHistoryService {

    @Autowired
    WatchHistoryMapper watchHistoryMapper;

    @Override
    public List<WatchHistory> getWatchHistoryByUserId(Long userId) {
        return watchHistoryMapper.getWatchHistoryByUserId(userId);
    }

    @Override
    public int insertWatchHistory(WatchHistory watchHistory) {
        return watchHistoryMapper.insertWatchHistory(watchHistory);
    }

    @Override
    public int deleteHistory(Long userId) {
        return watchHistoryMapper.deleteHistory(userId);
    }

    @Override
    public List<WatchHistory> getWatchHistoryById(Long userId, Long videoId) {
        return watchHistoryMapper.getWatchHistoryById(userId, videoId);
    }
}
