package com.cm.service;

import com.cm.dao.UserDao;
import com.cm.dto.UpdateUserDto;
import com.cm.dto.UserDto;
import com.cm.model.User;
import com.cm.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	public User login(UserDto dto) {
		User user = userDao.getUser(dto.getId());

		if (user!=null && user.getPassword().equals(dto.getPassword())){
			return user;
		}else {
			return null;
		}
	}

	public boolean addUser(User userModel) {

		userModel.setRegistrationDate(LocalDateTime.now());
		userModel.setStatus(0);
		return userDao.addUser(userModel);
	}

	public boolean updateUser(UpdateUserDto dto) {
		boolean b = userDao.updateUser(dto);
		if (b){

			User user = Tool.getUSER();
			user.setUsername(dto.getUsername());
			user.setEmail(dto.getEmail());
			Tool.setUSER(user);
		}
		return b;
	}

	public boolean deleteUser(String id) {
		return userDao.deleteUser(id);
	}

	public int update(String password){
		return userDao.update(Tool.getUserID(),password);
	}
}
