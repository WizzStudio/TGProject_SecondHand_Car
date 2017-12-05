package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarService;

public class TG_CarDeleteByIdAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	//感觉这里可以加入一个struts2的validate
	public String execute()throws Exception{
		tcs.deleteById(id);
		return SUCCESS;
	}
}
