package com.tg.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.User;
import com.tg.service.UserService;

public class UserAction extends ActionSupport {
	
	private String username;
	private String password;

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception
	{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.saveUser(user);
		return SUCCESS;
	}
}
