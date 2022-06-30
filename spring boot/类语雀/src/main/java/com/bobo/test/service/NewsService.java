package com.bobo.test.service;

import com.bobo.test.pojo.Classes;
import com.bobo.test.pojo.News;

import java.util.Collection;

public interface NewsService {

    public int addNews(News news);

    public Collection<News> queryAllNews();

    public Collection<News> queryNewsByIfy(String news_ify);

    public Collection<News> queryNewsByName(String news_head);

    public Collection<News> queryNewsByAuthor(String news_author);

    public News queryNewsByNum(String num);

    public int updateNews(News news);

    public int deleteNews(String news_num);
}
