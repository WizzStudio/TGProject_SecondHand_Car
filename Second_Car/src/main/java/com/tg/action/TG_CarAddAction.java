package com.tg.action;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;

public class TG_CarAddAction extends ActionSupport {
	private int cid;
	private String pic;
	private String brand;
	private int year;
	private double price;
	private Date publishTime;
	
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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

	
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}


	public String execute()throws Exception{
		System.out.println(cid);
		System.out.println(publishTime.toString());
		return SUCCESS;
	}
}
