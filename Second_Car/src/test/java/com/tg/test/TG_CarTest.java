package com.tg.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.domain.TG_Car;
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
	@Test
	public void test3(){
		tcs.deleteById(0);
	}
	@Test
	public void test4(){
		tcs.deleteAll();
	}
	@Test
	public void test5(){
		TG_Car car3 = new TG_Car(1,"werwer","123",1997,20,new Date());
		tcs.add(car3);
	}
}
