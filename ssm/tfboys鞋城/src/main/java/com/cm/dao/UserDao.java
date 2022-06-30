package com.cm.dao;

import com.cm.dto.UpdateUserDto;
import com.cm.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

	List<User> getAllUsers();

	User getUser(Long id);

	boolean addUser(User userModel);

	boolean updateUser(UpdateUserDto dto);

	boolean deleteUser(String id);

	int update(@Param("id") Integer id,@Param("password") String password);
}
