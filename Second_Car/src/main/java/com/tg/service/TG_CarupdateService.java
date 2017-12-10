package com.tg.service;

import com.tg.domain.TG_Car;

public interface TG_CarupdateService {
	public boolean updatePrice(double price,int id);
	
	public boolean updateBrand(String brand,int id);
	
	public boolean updatePic(String pic,int id);
	public boolean updateAll(TG_Car car ,int id);
}
