package com.tg.domain;

import java.util.Date;

public class TG_Car {
	private int cid;
	private String pic;
	private String brand;
	private int year;
	private double price;
	private Date publishTime;
	
	
	
	public TG_Car(int cid, String pic, String brand, int year, double price,
			Date publishTime) {
		super();
		this.cid = cid;
		this.pic = pic;
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.publishTime = publishTime;
	}
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
	
	
}
