package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarService;

public class TG_CarDeleteAllAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	
	public String execute()throws Exception{
		tcs.deleteAll();
		return SUCCESS;
	}
}
