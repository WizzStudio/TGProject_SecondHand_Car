package com.tg.dao;

import java.util.List;

public interface TG_CarPageDao {
	public List getAllCar(int currentPage,int pageSize);
	
	public int findCarSize();
}
