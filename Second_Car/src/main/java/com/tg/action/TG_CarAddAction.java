package com.tg.action;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;
import com.tg.util.ImageUtils;

public class TG_CarAddAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private static final String ROOT ="http://119.23.75.180:8080/SecondCar/TG_Photo";
	private static final String PATH="/TG_Photo";

	
	private int cid;
	private String brand;
	private int year;
	private double price;
	private String info;
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	//需要返回的值
	private int code;	//添加成功的状态
	private String msg;	//添加成功的返回信息
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
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
		System.out.println(fileFileName);
		System.out.println(fileContentType);
		String url = ROOT+"/"+fileFileName;
		if(ImageUtils.isImage(fileContentType)){
			code = 0;
			msg="文件类型错误";
		}
		TG_Car car = new TG_Car(url, brand, year, price, info);
		ImageUtils.copyFile(PATH, fileFileName, file);
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
