package com.tg.service;

public interface TG_CarupdateService {
	public boolean updatePrice(double price,int id);
	
	public boolean updateBrand(String brand,int id);
	
	public boolean updatePic(String pic,int id);
}
