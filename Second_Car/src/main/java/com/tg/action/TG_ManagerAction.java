package com.tg.action;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_ManagerService;

public class TG_ManagerAction extends ActionSupport {
	@Autowired
	private TG_ManagerService tms;
	

	private String username;
	private String password;
	
	//返回属性
	private  String msg;	//返回信息
	private int code;	//返回状态码
	
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
	
	@JSON(serialize=false)   //不需要返回
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute()throws Exception{
		
		System.out.println(username);
		System.out.println(password);
		if(username==null||password==null||!tms.isLogin(username, password)){
			code = 0;
			msg = "用户名或者密码错误！";
			return ERROR;
		}
		code = 1;
		msg = "登录成功！";
		return SUCCESS;
	}
	
}
