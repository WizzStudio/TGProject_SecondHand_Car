package com.tg.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tg.dao.TG_CarPageDao;
@Repository
public class TG_CarPageDaoImp implements TG_CarPageDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List getAllCar(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from TG_Car";
		Query query=getSession().createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List cars=query.list();
		if(cars.size()<=0||cars==null){
			return null;
		}
		return cars;
	}

	@Override
	public int findCarSize() {
		// TODO Auto-generated method stub
		String hql="from TG_Car";
		int size=getSession().createQuery(hql).list().size();
		return size;
	}

}
