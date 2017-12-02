package com.tg.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tg.dao.TG_CarDao;
import com.tg.domain.TG_Car;
@Repository
public class TG_CarDaoImp implements TG_CarDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean add(TG_Car car) {
		// TODO Auto-generated method stub
		getSession().save(car);
		return true;
	}


	@Override
	public List selectById(int id) {
		// TODO Auto-generated method stub
		String hql;
		List<TG_Car>tgc_list;
		
		hql="from TG_Car where cid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, id);
		tgc_list=query.list();
		
		if(tgc_list==null||tgc_list.size()==0){
			System.out.println("不存在");
			return null;
		}
		
		return tgc_list;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		String hql;
		List<TG_Car>tgc_list;
		
		hql="from TG_Car tg_car";
		Query query=getSession().createQuery(hql);
		tgc_list=query.list();
		
		if(tgc_list==null||tgc_list.size()==0){
			System.out.println("不存在");
			return null;
		}
		
		return tgc_list;
	}


}
