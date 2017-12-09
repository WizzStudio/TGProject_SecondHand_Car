package com.tg.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarService;

public class TG_CarDeleteAllAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	
	private String msg;
	private int code;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String execute()throws Exception{
		if(tcs.deleteAll())
		{
			msg = "删除成功";
			code = 1;
			return SUCCESS;
		}else{
			code = 0;
			msg = "删除失败";
			return ERROR;
		}
	}
}
