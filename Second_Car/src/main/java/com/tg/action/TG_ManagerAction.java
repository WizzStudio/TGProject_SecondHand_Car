package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Manager;
import com.tg.service.TG_ManagerService;

public class TG_ManagerAction extends ActionSupport {
	@Autowired
	private TG_ManagerService tms;
	
	private TG_Manager manager;
	
	public TG_Manager getManager() {
		return manager;
	}
	public void setManager(TG_Manager manager) {
		this.manager = manager;
	}
	
	public String execute()throws Exception{
		String name=manager.getUserName();
		String pass=manager.getPassword();
		
		if(name==null||pass==null||!tms.isLogin(name, pass)){
			return ERROR;
		}
		
		return SUCCESS;
	}
	
}
