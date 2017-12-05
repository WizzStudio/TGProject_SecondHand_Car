package com.tg.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.dao.TG_CarPageDao;
import com.tg.service.TG_CarPagerService;
@Service
public class TG_CarPagerServiceImp implements TG_CarPagerService {
	@Autowired
	private TG_CarPageDao tcpd;
	
	@Override
	public List getAllCar(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return tcpd.getAllCar(currentPage, pageSize);
	}

	@Override
	public int findCarSize() {
		// TODO Auto-generated method stub
		return tcpd.findCarSize();
	}

}
