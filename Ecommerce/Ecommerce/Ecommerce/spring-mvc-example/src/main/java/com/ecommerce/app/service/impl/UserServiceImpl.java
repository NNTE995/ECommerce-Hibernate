package com.ecommerce.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.UserDao;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	//static int count =0;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void saveUser(User user) {		
		//user.setUserId(count++);
		userDao.saveUser(user);
	}

	@Override
	public User authenticateUser(String name, String password) {
						
		return userDao.authenticateUser(name,password);
	}
}