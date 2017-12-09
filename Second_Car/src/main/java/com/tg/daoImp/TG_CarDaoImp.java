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
	
	//deleteById
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		try{
			String hql;
			Query query;
			
			hql="delete from TG_Car where cid=?";
			query=getSession().createQuery(hql);
			query.setInteger(0, id);
			query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		System.out.println("delete");
		return true;
	}
	//deleteAll
	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		try{
			String hql;
			Query query;
			
			hql="delete from TG_Car";
			query=getSession().createQuery(hql);
			query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		System.out.println("delete all");
		return true;
	}

	//add
	@Override
	public boolean add(TG_Car car) {
		// TODO Auto-generated method stub
		getSession().save(car);
		return true;
	}

	//selectById
	@Override
	public TG_Car selectById(int id) {
		// TODO Auto-generated method stub
		String hql;
		List<TG_Car>tgc_list;
		
		hql="from TG_Car where cid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, id);
		tgc_list=query.list();
		
		if(tgc_list==null||tgc_list.size()<=0){
			System.out.println("������");
			return null;
		}
		
		return tgc_list.get(0);
	}
	//delete all
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		String hql;
		List<TG_Car>tgc_list;
		
		hql="from TG_Car tg_car";
		Query query=getSession().createQuery(hql);
		tgc_list=query.list();
		
		if(tgc_list==null||tgc_list.size()==0){
			System.out.println("error");
			return null;
		}
		
		return tgc_list;
	}


}
