package com.bobo.test.mapper;

import com.bobo.test.pojo.User;
import com.bobo.test.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {

    int registration(User user);

    User getUserById(Integer id);

    UserVo getUserVoById(Integer id);

    Integer getUserIdByPainterId(Integer painterId);

    int update(Integer id,String email,String name);

    int updateStatus(Integer id,Integer status);

    int updatePic(String pic,Integer id);
}
