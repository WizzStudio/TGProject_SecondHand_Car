package com.tg.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.dao.TG_CarUpdateDao;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarupdateService;
@Service
public class TG_CarupdateServiceImp implements TG_CarupdateService {
	@Autowired
	private TG_CarUpdateDao tcud;
	
	@Override
	public boolean updatePrice(double price, int id) {
		// TODO Auto-generated method stub
		return tcud.updatePrice(price, id);
	}

	@Override
	public boolean updateBrand(String brand, int id) {
		// TODO Auto-generated method stub
		return tcud.updateBrand(brand, id);
	}

	@Override
	public boolean updatePic(String pic, int id) {
		// TODO Auto-generated method stub
		return tcud.updatePic(pic, id);
	}

	@Override
	public boolean updateAll(TG_Car car, int id) {

		return tcud.updateAll(car, id);
	}

}
