package com.tg.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	@Test
	public void testConnection()
	{
		String path="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		SessionFactory session = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(session.openSession());
	}
}
