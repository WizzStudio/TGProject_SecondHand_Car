package com.tg.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.domain.User;
import com.tg.service.UserService;
public class TestMain {

	@Test
	public void testConnection()
	{
		System.out.println("haah");
		String path="application-transaction.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		SessionFactory sessionFactory=(SessionFactory)ac.getBean("SessionFactory");
		sessionFactory.openSession();
		System.out.println("open");
		sessionFactory.close();
		System.out.println("close");
	}
}
