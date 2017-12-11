package com.tg.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;
import com.tg.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class TG_CarAddActionAdapter extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private static final String ROOT ="http://119.23.75.180:8080/SecondCar/TG_Photo";
	private static final String PATH="/TG_Photo";

	
	private int cid;
	private String brand;
	private int year;
	private double price;
	private String info;
	
	private File[] files;
	private String[] filesFileName;
	private String[] filesContentType;

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}

	//需要返回的值
	private int code;	//添加成功的状态
	private String msg;	//添加成功的返回信息
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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

		for(int i=0;i<files.length;i++)
		{
			if(!ImageUtils.isImage(filesContentType[i]))
			{
				code = 0;
				msg="文件类型错误";
				return ERROR;
			}
		}
		String url = ROOT+"/"+filesFileName[0];

		TG_Car car = new TG_Car(url, brand, year, price, info);
		for(int i=0;i<files.length;i++)
		{
			String[] arr = filesFileName[0].split("\\.");
			String  filename = arr[0]+"_"+i+"."+arr[1];
			ImageUtils.copyFile(PATH, filename, files[i]);
		}
		if(tcs.add(car))
		{
			//添加成功
			code = 1;
			msg = "添加成功";
			return SUCCESS;
		}else{
			code =0 ;
			msg = "添加失败";
			return ERROR;
		}
		
	}
}
