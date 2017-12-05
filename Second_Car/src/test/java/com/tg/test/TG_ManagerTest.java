package com.tg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.domain.TG_Manager;
import com.tg.service.TG_ManagerService;

public class TG_ManagerTest {
	private ApplicationContext app;
	private TG_ManagerService tms;
	
	{
		app=new ClassPathXmlApplicationContext("applicationContext.xml");
		tms=app.getBean(TG_ManagerService.class);
	}
	@Test
	public void test(){
		String name="Tom";
		String password="Ted";
		System.out.println(tms.isLogin(name,password));
	}
	
}
