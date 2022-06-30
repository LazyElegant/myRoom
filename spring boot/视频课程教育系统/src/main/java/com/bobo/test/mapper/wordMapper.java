package com.bobo.test.mapper;

import com.bobo.test.pojo.word;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author admin
 * @create 2021/5/2 14:42
 */

@Repository
@Mapper
public interface wordMapper {

    public int addWord(word word);

    public word getWord(Long id,Long user_id);

    public String getWordById(Long id);

    public List<word> listWordById(Long id);
}
