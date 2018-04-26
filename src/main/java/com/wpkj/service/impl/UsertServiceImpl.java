package com.wpkj.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wpkj.domain.Usert;
import com.wpkj.mapper.UsertMapper;
import com.wpkj.service.UsertService;
@Service
public class UsertServiceImpl implements UsertService {
	public UsertMapper usermapper;
	@Autowired
	public void setUsermapping(UsertMapper usermapper) {
		this.usermapper = usermapper;
	}

	@Override
	public Usert getEntity(int id) {
		// TODO Auto-generated method stub
		return usermapper.getEntity(id);
	}

	@Override
	public List<Usert> userList() {
		// TODO Auto-generated method stub
		return usermapper.userList();
	}
	@Override
	public Map<String, Object> insertUsert(Usert usert) {
		usert.setUid(UUID.randomUUID().toString());
		int i=usermapper.insertUsert(usert);
		String state=i>0?"200":"500";
		Map<String, Object> hash=new HashMap<String, Object>();
		hash.put("state", state);
		return hash;
	}
	public Map<String, Object> updateUsert(Usert usert) {
		int i=usermapper.updateUsert(usert);
		String state=i>0?"200":"500";
		Map<String, Object> hash=new HashMap<String, Object>();
		hash.put("state", state);
		return hash;
	}
	@Override
	public Map<String, Object> deleteUsert(Usert usert) {
		Map<String, Object> hash=new HashMap<String, Object>();
		int result=0;
		if(StringUtils.isEmpty(usert.getUid())) {
			hash.put("state", "500");
			return hash;
		}
		String[] primarys = usert.getUid().split(",");
		if(primarys.length==1){
			result += usermapper.deleteUsert(usert);
		}else{
			result += usermapper.deleteUserts(Arrays.asList(primarys));
		}	
		String state=result>0?"200":"500";
		hash.put("state", state);
		hash.put("count", result);
		return hash;
	}

}
