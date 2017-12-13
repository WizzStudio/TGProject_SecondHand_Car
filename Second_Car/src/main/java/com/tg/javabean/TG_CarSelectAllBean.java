package com.tg.javabean;

import java.util.ArrayList;
import java.util.List;

import com.tg.domain.TG_Car;

public class TG_CarSelectAllBean {

	private int code;
	private String msg;
	private List<TG_Car> car = new ArrayList<TG_Car>();

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

	public List<TG_Car> getCar() {
		return car;
	}

	public void setCar(List<TG_Car> car) {
		this.car = car;
	}
}
