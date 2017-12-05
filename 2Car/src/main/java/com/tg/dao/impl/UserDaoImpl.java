package com.tg.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tg.dao.UserDao;
import com.tg.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public boolean addUser(User user) {

		String 	queryString = "from User where username ="+user.getUsername();
		List<User> lists = this.getHibernateTemplate().find(queryString);
		if(lists.size()==0)
		{
			return false;
		}else{
			this.getHibernateTemplate().save(user);
			return true;
		}
	}

}
