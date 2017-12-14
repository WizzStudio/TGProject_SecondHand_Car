package com.tg.domain;

import java.util.HashSet;
import java.util.Set;

public class TG_CarAdapter {

	private int cid;
	private String brand;
	private int year;
	private double price;
//	private Date publishTime;
	private String info;	//车辆信息
	private Set<TG_Img> img = new HashSet<TG_Img>();

	public TG_CarAdapter() {
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

	public Set<TG_Img> getImg() {
		return img;
	}

	public void setImg(Set<TG_Img> img) {
		this.img = img;
	}
}
