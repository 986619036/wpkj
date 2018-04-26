package com.wpkj.service;

import java.util.List;
import java.util.Map;

import com.wpkj.domain.Usert;

public interface UsertService {
	Usert getEntity(int id);
	
	List<Usert> userList();
	
	Map<String, Object> insertUsert(Usert usert);
	
	public Map<String, Object> updateUsert(Usert usert);
	
	Map<String, Object> deleteUsert(Usert usert);
}
