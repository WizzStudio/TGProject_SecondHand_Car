package com.tg.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;

public class TG_CarSelectAllAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	
	private List<TG_Car> cars=new ArrayList<TG_Car>();

	public List<TG_Car> getCars() {
		return cars;
	}
	public void setCars(List<TG_Car> cars) {
		this.cars = cars;
	}

	public String execute()throws Exception{
		cars=tcs.selectAll();
		if(cars==null||cars.size()<0){
			return ERROR;
		}
		return SUCCESS;
		
	}
}
