package com.tg.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
        System.out.println(sessionFactory);
        Session session = sessionFactory.openSession();
        System.out.println(session.isConnected());
    }
}
