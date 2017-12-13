package com.tg.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.tg.javabean.TG_CarAdapter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.javabean.TG_CarSelectByIdBean;
import com.tg.service.TG_CarService;

public class TG_CarSelectByIdAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private int id;
	private static final String ROOT ="http://119.23.75.180:8080/SecondCar/TG_Photo";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//需要返回的值
	private TG_CarSelectByIdBean car = new TG_CarSelectByIdBean();
	
	public TG_CarService getTcs() {
		return tcs;
	}

	public void setTcs(TG_CarService tcs) {
		this.tcs = tcs;
	}

	public TG_CarSelectByIdBean getCar() {
		return car;
	}

	public void setCar(TG_CarSelectByIdBean car) {
		this.car = car;
	}

	public String execute() throws Exception{
		String msg = null;
		int code ;
		TG_Car tCar = new TG_Car();
		tCar=tcs.selectById(id);

		if(tCar==null){
			msg = "所选内容为空";
			code = 0;
			car.setCode(code);
			car.setMsg(msg);
			return ERROR;
		}
		car.setCode(1);
		car.setMsg("成功");
		TG_CarAdapter tg_carAdapter = new TG_CarAdapter();
		List<String> urls = new ArrayList<String>();
		String url = tCar.getPic().substring(45);
		String fileName = url.split("_")[0];
		String path = "/TG_Photo/";
		String rootName= ServletActionContext.getServletContext().getRealPath(path);
		File file = new File(rootName);
		File[] tempList = file.listFiles();
		for(File f:tempList)
		{
			if(Pattern.matches(fileName,f.getName().split("_")[0])){
				urls.add(ROOT+"/"+f.getName());
			}
		}
		tg_carAdapter.setUrls(urls);
		tg_carAdapter.setTg_car(tCar);
		car.setCar(tg_carAdapter);
		return SUCCESS;
	}
}
