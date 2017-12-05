package com.tg.dao;

public interface TG_CarUpdateDao {
	public boolean updatePrice(double price,int id);
	
	public boolean updateBrand(String brand,int id);
	
	public boolean updatePic(String pic,int id);
}
