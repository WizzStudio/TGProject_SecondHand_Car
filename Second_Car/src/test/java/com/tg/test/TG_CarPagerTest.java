package com.tg.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.service.TG_CarPagerService;

public class TG_CarPagerTest {
	private ApplicationContext app;
	private TG_CarPagerService tcps;
	
	{
		app=new ClassPathXmlApplicationContext("applicationContext.xml");
		tcps=app.getBean(TG_CarPagerService.class);
	}
	
	@Test
	public void test(){
		List list=tcps.getAllCar(1,5);
		System.out.println(list.get(0).getClass().getName());
		System.out.println("success");
	}
}
