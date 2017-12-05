package com.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tg.dao.UserDao;
import com.tg.domain.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(user==null){
			return false;
		}
		getSession().save(user);
		return true;
	}

	

}
