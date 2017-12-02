package com.tg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.service.TG_CarService;

public class TG_CarTest {
	private ApplicationContext app;
	private TG_CarService tcs;
	
	{
		app=new ClassPathXmlApplicationContext("applicationContext.xml");
		tcs=app.getBean(TG_CarService.class);
	}
	
	@Test
	public void test(){
		int id=0;
		tcs.selectById(id);
	}
	
	@Test
	public void test2(){
		tcs.selectAll();
	}
}
