package com.bobo.test.service;

import com.bobo.test.mapper.wordMapper;
import com.bobo.test.pojo.word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author admin
 * @create 2021/5/2 14:44
 */
@Service
public class wordServiceImpl implements wordService{
    @Autowired
    wordMapper wordMapper;

    @Override
    public int addWord(word word) {
        return wordMapper.addWord(word);
    }

    @Override
    public word getWord(Long id, Long user_id) {
        return wordMapper.getWord(id,user_id);
    }

    @Override
    public String getWordById(Long id) {
        return wordMapper.getWordById(id);
    }

    @Override
    public List<word> listWordById(Long id) {
        return wordMapper.listWordById(id);
    }
}
