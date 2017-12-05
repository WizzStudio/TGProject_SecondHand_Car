package com.tg.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tg.javabean.Page;
import com.tg.util.PageUtil;

public class TestPage {

	@Test
	public void test()
	{
		
		List<User> list = new ArrayList<User>();
		User user = new User("lxy","lxy");
		User user1 = new User("stc","stc");
		User user2 = new User("ssb","ssb");
		User user3 = new User("233","233");
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user1);
		
		Page<User> page = PageUtil.createPage(list, list.size(), 5, 3);
		System.out.println(page.getBeginIndex());
		System.out.println(page.getTotalPage());
		System.out.println(page.getTotalCount());
		
	}
}

class User
{
	private String name;
	private String password;
	
	public User()
	{
		
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}