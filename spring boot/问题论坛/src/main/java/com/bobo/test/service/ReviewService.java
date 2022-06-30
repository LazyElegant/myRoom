package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.mapper.ReviewMapper;
import com.bobo.test.pojo.Review;
import com.bobo.test.vo.ReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewMapper mapper;

    public int insertReview(Review review){
        review.setId(Tool.getID());
        review.setUserId(Tool.getUserID());
        review.setReviewTime(LocalDateTime.now());
        return mapper.insertReview(review);
    }

    public List<ReviewVo> listReview(Integer id){
        return mapper.listReview(id);
    }
}
