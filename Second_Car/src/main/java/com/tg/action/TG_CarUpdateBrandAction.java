package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarupdateService;

public class TG_CarUpdateBrandAction extends ActionSupport {
	@Autowired
	private TG_CarupdateService tcus;
	
	private TG_Car car;
	public TG_Car getCar() {
		return car;
	}
	public void setCar(TG_Car car) {
		this.car = car;
	}


	public String execute()throws Exception{
		String brand;
		int id;
		
		brand=car.getBrand();
		id=car.getCid();
		
		if(tcus.updateBrand(brand, id)){
			return SUCCESS;
		}
		
		return ERROR;
	}
}
