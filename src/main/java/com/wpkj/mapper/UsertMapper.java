package com.wpkj.mapper;

import java.util.List;

import com.wpkj.domain.Usert;

public interface UsertMapper {
	
	Usert getEntity(int id);
	
	List<Usert> userList();
	
	Integer insertUsert(Usert us);
	
	Integer updateUsert(Usert us);
	
	Integer deleteUsert(Usert us);
	Integer deleteUserts(List<String> list);
}
