package com.tg.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tg.dao.UserDao;
import com.tg.domain.User;
import com.tg.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userdao.addUser(user);
	}
	
	
}
