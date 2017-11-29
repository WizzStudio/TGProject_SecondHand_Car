package com.tg.domain;

public class User {
	private Integer id;
	private String username;
	private String password;

	public User() {

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("{");
		sb.append("\"username\":").append(",\"" + username + "\"");
		sb.append("\"password\":").append(",\"" + password + "\"");
		return sb.toString();
	}
}
