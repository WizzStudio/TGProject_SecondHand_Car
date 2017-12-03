package com.tg.service;

import java.util.List;

public interface TG_CarPagerService {
	public List getAllCar(int currentPage,int pageSize);
	
	public int findCarSize();
}
