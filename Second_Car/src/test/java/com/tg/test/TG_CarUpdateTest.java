package com.tg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.service.TG_CarupdateService;

public class TG_CarUpdateTest {
	private ApplicationContext app;
	private TG_CarupdateService tcus;
	{
		app=new ClassPathXmlApplicationContext("applicationContext.xml");
		tcus=app.getBean(TG_CarupdateService.class);
	}
	@Test
	public void test(){
		boolean test=tcus.updatePrice(10.5, 0);
		System.out.println(test);
	}
}
