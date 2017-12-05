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
	
	//按id删除
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
	//删除所有
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

	//添加新汽车
	@Override
	public boolean add(TG_Car car) {
		// TODO Auto-generated method stub
		getSession().save(car);
		return true;
	}

	//按序号查找
	@Override
	public List selectById(int id) {
		// TODO Auto-generated method stub
		String hql;
		List<TG_Car>tgc_list;
		
		hql="from TG_Car where cid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, id);
		tgc_list=query.list();
		
		if(tgc_list==null||tgc_list.size()<=0){
			System.out.println("不存在");
			return null;
		}
		
		return tgc_list;
	}
	//查询所有
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
