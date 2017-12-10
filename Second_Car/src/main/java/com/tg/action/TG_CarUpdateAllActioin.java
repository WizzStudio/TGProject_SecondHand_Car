package com.tg.action;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarupdateService;
import com.tg.util.ImageUtils;

public class TG_CarUpdateAllActioin extends ActionSupport{
	@Autowired
	private TG_CarupdateService tcs;
	private static final String PATH="/TG_Photo";
	private int id;
	private File pic;
	private String picFileName;
	private String fileContentType;
	private String brand;
	private int year;
	private double price;
	private String info;
	private String msg;
	private int code;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
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
	

	public File getPic() {
		return pic;
	}


	public void setPic(File pic) {
		this.pic = pic;
	}


	public String getPicFileName() {
		return picFileName;
	}


	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
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


	public String execute() throws Exception
	{
		String picPath = ImageUtils.ROOT+picFileName;
		if(!ImageUtils.isImage(fileContentType))
		{
			msg = "文件类型不对";
			code = 0;
			return ERROR;
		}
		TG_Car car = new TG_Car(picPath, brand, year, price, info);
		ImageUtils.copyFile(PATH, picFileName, pic);
		if(tcs.updateAll(car, id))
		{
			code =1;
			msg = "更新成功";
			return SUCCESS;
		}else{
			code = 0;
			msg = "更新失败";
			return ERROR;
		}
	}
}
