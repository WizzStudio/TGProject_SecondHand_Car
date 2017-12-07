package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarupdateService;

public class TG_CarUpdatePriceAction extends ActionSupport {
	@Autowired
	private TG_CarupdateService tcus;
	private int id;
	private double price;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	public String execute()throws Exception{
		System.out.println(price);
		System.out.println(id);
		tcus.updatePrice(price, id);
		return SUCCESS;
	}
}
