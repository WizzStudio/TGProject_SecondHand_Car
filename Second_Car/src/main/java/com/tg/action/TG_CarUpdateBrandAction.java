package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarupdateService;

public class TG_CarUpdateBrandAction extends ActionSupport {
	@Autowired
	private TG_CarupdateService tcus;
	private int id;
	private String brand;
	
	private int code;
	private String msg;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute()throws Exception{
	
		if(tcus.updateBrand(brand, id)){
			code = 1;
			msg="更新成功";
			return SUCCESS;
		}
		code = 0;
		msg = "更新失败";
		return ERROR;
	}
}
