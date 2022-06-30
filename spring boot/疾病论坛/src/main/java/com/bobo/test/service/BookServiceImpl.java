package com.bobo.test.service;

import com.bobo.test.mapper.BookMapper;
import com.bobo.test.pojo.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    BookMapper bookMapper;

    @Override
    public book queryBookByUserId(int book_user_id) {
        return bookMapper.queryBookByUserId(book_user_id);
    }

    @Override
    public List<book> queryBookAll() {
        return bookMapper.queryBookAll();
    }


}
