package com.bobo.test.service;

import com.bobo.test.mapper.ReviewMapper;
import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReviewServiceImpl implements ReviewService{


    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public int addReview(Review review) {
        return reviewMapper.addReview(review);
    }

    @Override
    public Collection<Review> queryNewsByNum(String news_num) {
        return reviewMapper.queryNewsByNum(news_num);
    }
}
