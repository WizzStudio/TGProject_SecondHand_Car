package com.tg.resourceteest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.action.TG_ManagerAction;

public class TestStrutsBean {
	private ApplicationContext app;
	
	@Test
	public void test(){
		app=new ClassPathXmlApplicationContext("strutsBean.xml");
		TG_ManagerAction tma=(TG_ManagerAction) app.getBean("TG_ManagerAction");
		System.out.println(tma.getClass().getName());
	}
}
