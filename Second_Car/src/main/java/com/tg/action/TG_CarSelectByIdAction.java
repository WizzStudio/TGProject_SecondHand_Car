package com.tg.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
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
	
	public String execute()throws Exception{
		List<TG_Car>list=tcs.selectById(id);
		if(list==null||list.size()==0){
			return ERROR;
		}
		return SUCCESS;
	}
}
