package com.bobo.test.service;


import com.bobo.test.pojo.book;

import java.util.List;

public interface BookService {

    public book queryBookByUserId(int book_user_id);

    public List<book> queryBookAll();
}
