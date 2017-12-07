package com.tg.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;

public class TG_CarSelectByIdAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	
	//需要返回的值
	private List<TG_Car> list = new ArrayList<TG_Car>();
	private int id;
	
	
	public List<TG_Car> getList() {
		return list;
	}
	public void setList(List<TG_Car> list) {
		this.list = list;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String execute()throws Exception{
		list=tcs.selectById(id);
		//静态数据模拟
		/*TG_Car car = new TG_Car(1,"werwer","123",1997,20,new Date());
		TG_Car car1 = new TG_Car(1,"werwer","123",1997,20,new Date());
		TG_Car car2 = new TG_Car(1,"werwer","123",1997,20,new Date());
		list.add(car);
		list.add(car1);
		list.add(car2);
		TG_Car car3 = new TG_Car(1,"werwer","123",1997,20,new Date());
		list.add(car3);*/
		if(list==null||list.size()==0){
			return ERROR;
		}
		return SUCCESS;
	}
}
