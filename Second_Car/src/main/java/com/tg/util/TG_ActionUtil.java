package com.tg.util;

import java.util.List;

import com.tg.domain.TG_Car;

public interface TG_ActionUtil {
public List selectById(int id);
	
	public List selectAll();
	
	public boolean deleteById(int id);
	
	public boolean deleteAll();
	
	public boolean add(TG_Car car);
}
