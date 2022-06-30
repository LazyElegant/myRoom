package com.bobo.test.service;

import com.bobo.test.config.Tool;
import com.bobo.test.dto.LoginDto;
import com.bobo.test.mapper.UserMapper;
import com.bobo.test.pojo.User;
import com.bobo.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean Login(LoginDto dto){
        User user = userMapper.getUserById(dto.getId());
        if (user != null && user.getPassword().equals(dto.getPassword())){
            Tool.setUSER(userMapper.getUserVoById(dto.getId()));
            return true;
        }else {
            return false;
        }
    }

    public boolean registration(User user) {

        if (userMapper.getUserById(user.getId()) != null){
            return false;
        }else {
            user.setRegistrationTime(LocalDateTime.now());
            userMapper.registration(user);
            return true;
        }
    }

    public UserVo getUserVoById(Integer id){
        return userMapper.getUserVoById(id);
    }

    public int update(Integer id,String email,String name){
        return userMapper.update(id, email, name);
    }

    public int updatePic(MultipartFile file){
        return userMapper.updatePic(Tool.createPictures(file),Tool.getUserID());
    }
}
