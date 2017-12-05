package com.tg.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarPagerService;
import com.tg.util.TG_Page;

public class TG_CarPagerAction extends ActionSupport {
	@Autowired
	private TG_CarPagerService tcps;
	private int currentpage=1;
	private int pagesize=2;
	
	public String execute()throws Exception{
		List cars=tcps.getAllCar(currentpage, pagesize);
		if(cars.size()>0){
			Map session=ActionContext.getContext().getSession();
			Map request=(Map)ActionContext.getContext().get("request");
			
			session.put("cars", cars);
			TG_Page tgp=new TG_Page(currentpage,tcps.findCarSize(),pagesize);
			request.put("page",tgp);
			
			return SUCCESS;
		}
		return ERROR;
	}
	
}
