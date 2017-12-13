package com.tg.action;

import java.util.ArrayList;
import java.util.List;

import com.tg.javabean.TG_CarAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.javabean.TG_CarSelectAllBean;
import com.tg.service.TG_CarService;

public class TG_CarSelectAllAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private TG_CarSelectAllBean cars = new TG_CarSelectAllBean();

	private List<TG_Car> list=new ArrayList<TG_Car>();
	
	public TG_CarSelectAllBean getCars() {
		return cars;
	}

	public void setCars(TG_CarSelectAllBean cars) {
		this.cars = cars;
	}

	public List<TG_Car> getList() {
		return list;
	}

	public void setList(List<TG_Car> list) {
		this.list = list;
	}

	public String execute()throws Exception{
		String msg ;
		int code;
		list=tcs.selectAll();
		if(list==null||list.size()<0) {
			code = 0;
			msg = "查询失败";
			cars.setCode(code);
			cars.setMsg(msg);
			return ERROR;
		}
		cars.setCar(list);
		cars.setCode(1);
		cars.setMsg("成功");
		return SUCCESS;
		
	}
}
