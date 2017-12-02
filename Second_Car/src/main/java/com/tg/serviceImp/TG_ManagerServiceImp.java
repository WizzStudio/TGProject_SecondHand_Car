package com.tg.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.dao.TG_ManagerDao;
import com.tg.domain.TG_Manager;
import com.tg.service.TG_ManagerService;
@Service
public class TG_ManagerServiceImp implements TG_ManagerService {
	@Autowired
	private TG_ManagerDao tmd;

	@Override
	public boolean isLogin(String name, String password) {
		// TODO Auto-generated method stub
		return tmd.isLogin(name, password);
	}
	
	

}
