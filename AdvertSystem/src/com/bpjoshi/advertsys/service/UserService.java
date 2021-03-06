package com.bpjoshi.advertsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.bpjoshi.advertsys.dao.UserDao;
import com.bpjoshi.advertsys.model.User;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 * 
 *  */

@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void createAccount(User user) {
		 userDao.createAccount(user);
	}


	public boolean exists(String username) {
		userDao.exists(username);
		return false;
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}
}
