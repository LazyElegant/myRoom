package com.bobo.test.service;

import com.bobo.test.mapper.NewsMapper;
import com.bobo.test.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public int addNews(News news) {
        return newsMapper.addNews(news);
    }

    @Override
    public Collection<News> queryAllNews() {
        return newsMapper.queryAllNews();
    }

    @Override
    public Collection<News> queryNewsByIfy(String news_ify) {
        return newsMapper.queryNewsByIfy(news_ify);
    }

    @Override
    public Collection<News> queryNewsByName(String news_head) {
        return newsMapper.queryNewsByName(news_head);
    }

    @Override
    public News queryNewsByNum(String num) {
        return newsMapper.queryNewsByNum(num);
    }

    @Override
    public int updateNews(News news){
        return newsMapper.updateNews(news);
    }

    @Override
    public int deleteNews(String news_num) {
        return newsMapper.deleteNews(news_num);
    }
}
