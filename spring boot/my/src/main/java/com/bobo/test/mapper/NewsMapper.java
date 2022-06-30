package com.bobo.test.mapper;

import com.bobo.test.pojo.Classes;
import com.bobo.test.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface NewsMapper {

    public int addNews(News news);

    public Collection<News> queryAllNews();

    public Collection<News> queryNewsByIfy(String news_ify);

    public Collection<News> queryNewsByName(String news_head);

    public News queryNewsByNum(String num);

    public int updateNews(News news);

    public int deleteNews(String news_num);
}
