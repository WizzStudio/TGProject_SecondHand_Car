package com.tg.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;

public class TG_CarSelectAllAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	
	public String execute()throws Exception{
		List<TG_Car>cars=tcs.selectAll();
		
		if(cars==null||cars.size()<0){
			return ERROR;
		}
		
		return SUCCESS;
		
	}
}
