package com.tg.domain;

import javax.persistence.Entity;

public class TG_Car {

	private int cid;
	private String pic;
	private String brand;
	private int year;
	private double price;
//	private Date publishTime;
	private String info;	//车辆信息
	
	
	public TG_Car(String pic, String brand, int year, double price,
			String info) {
		super();
		this.pic = pic;
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.info = info;
	}
	
	public TG_Car() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
	
}
