package com.bobo.test.mapper;

import com.bobo.test.pojo.WatchHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WatchHistoryMapper {

    public List<WatchHistory> getWatchHistoryByUserId(Long userId);

    public int insertWatchHistory(WatchHistory watchHistory);

    public int deleteHistory(Long userId);

    public List<WatchHistory> getWatchHistoryById(Long userId,Long videoId);
}
