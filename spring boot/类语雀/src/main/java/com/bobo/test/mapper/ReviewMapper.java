package com.bobo.test.mapper;

import com.bobo.test.pojo.News;
import com.bobo.test.pojo.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface ReviewMapper {

    public int addReview(Review review);

    public Collection<Review> queryNewsByNum(String news_num);
}
