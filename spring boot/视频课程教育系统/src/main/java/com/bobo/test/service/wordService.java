package com.bobo.test.service;

import com.bobo.test.pojo.word;

import java.util.List;

/**
 * @Author admin
 * @create 2021/5/2 14:44
 */

public interface wordService {
    public int addWord(word word);

    public word getWord(Long id,Long user_id);

    public String getWordById(Long id);
    public List<word> listWordById(Long id);
}
