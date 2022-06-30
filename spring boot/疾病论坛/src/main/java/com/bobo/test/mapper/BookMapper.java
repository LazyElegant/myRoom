package com.bobo.test.mapper;

import com.bobo.test.pojo.book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
@Mapper
public interface BookMapper {

    public book queryBookByUserId(int id);

    public List<book> queryBookAll();

}
