package com.tg.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;

public class TG_CarSelectByIdAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	//需要返回的值
	private TG_Car car = null;
	private int id;
	private String msg;
	
	public TG_Car getCar() {
		return car;
	}
	public void setCar(TG_Car car) {
		this.car = car;
	}
	@JSON(serialize=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String execute() throws Exception{
		System.out.println(id);
		car=tcs.selectById(id);
		System.out.println(car);
		//静态数据模拟
		/*TG_Car car = new TG_Car(1,"werwer","123",1997,20,new Date());
		TG_Car car1 = new TG_Car(1,"werwer","123",1997,20,new Date());
		TG_Car car2 = new TG_Car(1,"werwer","123",1997,20,new Date());
		list.add(car);
		list.add(car1);
		list.add(car2);
		TG_Car car3 = new TG_Car(1,"werwer","123",1997,20,new Date());
		list.add(car3);*/
		if(car==null){
			msg = "所选内容为空";
			return ERROR;
		}
		return SUCCESS;
	}
}
