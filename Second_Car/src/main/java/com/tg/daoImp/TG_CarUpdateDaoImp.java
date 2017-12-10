package com.tg.daoImp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tg.dao.TG_CarUpdateDao;
import com.tg.domain.TG_Car;
@Repository
public class TG_CarUpdateDaoImp implements TG_CarUpdateDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean updatePrice(double price, int id) {
		// TODO Auto-generated method stub
		TG_Car car=new TG_Car();
		
		try{
			car.setCid(id);
			car.setPrice(price);
			getSession().update(car);
			System.out.println("update price");
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateBrand(String brand, int id) {
		// TODO Auto-generated method stub
		TG_Car car=new TG_Car();
		
		try{
			car.setCid(id);
			car.setBrand(brand);
			getSession().update(car);
			System.out.println("update");
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	
	@Override
	public boolean updatePic(String pic, int id) {
		// TODO Auto-generated method stub
		TG_Car car=(TG_Car) getSession().get(TG_Car.class, id);
		if(car!=null){
			car.setPic(pic);
			getSession().update(car);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAll(TG_Car car,int id) {
		TG_Car tg_car = (TG_Car) getSession().get(TG_Car.class,id);
		if(tg_car==null)
		{
			return false;
		}else{
			String hql = "update TG_Car car "
					+ "set car.pic=?,car.brand=?,car.year=?,car.price=?,car.info=?";
			Query query = getSession().createQuery(hql);
			query.setString(0, car.getPic());
			query.setString(1, car.getBrand());
			query.setInteger(2, car.getYear());
			query.setDouble(3, car.getPrice());
			query.setString(4, car.getInfo());
			query.executeUpdate();
			return true;
		}
	}
	
}
