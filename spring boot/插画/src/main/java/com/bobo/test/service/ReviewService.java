package com.bobo.test.service;

import com.bobo.test.mapper.ReviewMapper;
import com.bobo.test.pojo.Review;
import com.bobo.test.vo.ReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewMapper mapper;

    public int insertReview(Review review){
        return mapper.insertReview(review);
    }

    public List<ReviewVo> listByIkonId(Integer id){
        return mapper.listByIkonId(id);
    }

}
