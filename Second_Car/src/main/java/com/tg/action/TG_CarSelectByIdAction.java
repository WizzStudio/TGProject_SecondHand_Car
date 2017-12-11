package com.tg.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.javabean.TG_CarSelectByIdBean;
import com.tg.service.TG_CarService;

public class TG_CarSelectByIdAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//需要返回的值
	private TG_CarSelectByIdBean car = new TG_CarSelectByIdBean();
	
	public TG_CarService getTcs() {
		return tcs;
	}

	public void setTcs(TG_CarService tcs) {
		this.tcs = tcs;
	}

	public TG_CarSelectByIdBean getCar() {
		return car;
	}

	public void setCar(TG_CarSelectByIdBean car) {
		this.car = car;
	}

	public String execute() throws Exception{
		String msg = null;
		int code ;
		TG_Car tCar = new TG_Car();
		tCar=tcs.selectById(id);
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
			code = 0;
			car.setCode(code);
			car.setMsg(msg);
			return ERROR;
		}
		car.setCode(1);
		car.setMsg("成功");
		car.setCar(tCar);
		return SUCCESS;
	}
}
