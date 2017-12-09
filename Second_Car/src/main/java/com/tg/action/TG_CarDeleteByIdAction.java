package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarService;

public class TG_CarDeleteByIdAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private int id;
	
	//返回的信息
	private String msg;
	private int code;
	
	
	public TG_CarService getTcs() {
		return tcs;
	}
	public void setTcs(TG_CarService tcs) {
		this.tcs = tcs;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	//�о�������Լ���һ��struts2��validate
	public String execute()throws Exception{
		if(tcs.deleteById(id))
		{
			code = 1;
			msg = "删除成功";
			return SUCCESS;
		}else{
			code = 0;
			msg = "删除失败";
			return ERROR;
		}
	}
}
