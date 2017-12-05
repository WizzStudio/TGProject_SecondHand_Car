package com.tg.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tg.dao.TG_ManagerDao;
import com.tg.domain.TG_Manager;
@Repository
public class TG_ManagerDaoImp implements TG_ManagerDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean isLogin(String name,String password) {
		// TODO Auto-generated method stub
		String hql;
		
		System.out.println(name);
		System.out.println(password);
		hql="from TG_Manager where username=? and password=?";
		Query query=getSession().createQuery(hql);
		query.setString(0,name);
		query.setString(1,password);
		List<TG_Manager>list=query.list();
		
		if(list==null||list.size()==0){
			return false;
		}
		
		return true;
	}

	
	
}
