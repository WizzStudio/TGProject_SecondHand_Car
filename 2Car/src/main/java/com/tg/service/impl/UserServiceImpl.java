package com.tg.service.impl;

import com.tg.dao.UserDao;
import com.tg.domain.User;
import com.tg.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	//提供setter方法
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		userDao.addUser(user);
	}

}
