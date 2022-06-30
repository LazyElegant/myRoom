package com.bobo.test.mapper;

import com.bobo.test.pojo.Review;
import com.bobo.test.vo.ReviewVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {

    int insertReview(Review review);

    List<ReviewVo> listReview(Integer id);
}
