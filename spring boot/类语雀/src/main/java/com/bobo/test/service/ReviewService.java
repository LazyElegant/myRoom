package com.bobo.test.service;

import com.bobo.test.pojo.Review;

import java.util.Collection;

public interface ReviewService {

    public int addReview(Review review);

    public Collection<Review> queryNewsByNum(String news_num);
}
