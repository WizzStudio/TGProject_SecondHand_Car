package com.tg.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.dao.TG_CarDao;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;
@Service
public class TG_CarServiceImp implements TG_CarService {
	@Autowired
	private TG_CarDao tcd;
	
	@Override
	public List selectById(int id) {
		// TODO Auto-generated method stub
		return tcd.selectById(id);
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return tcd.selectAll();
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(TG_Car car) {
		// TODO Auto-generated method stub
		return false;
	}

}
