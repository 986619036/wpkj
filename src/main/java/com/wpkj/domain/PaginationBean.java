package com.wpkj.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
 * Simple to Introduction  
 * @Description:  [�?句话描述该类的功能]   
 * @Author:       [zhuxianning]    
 * @CreateDate:   [2015�?4�?9�? 上午8:54:01]   
 * @Version:      [v1.0]  
 **/
public class PaginationBean {
	/**
	 * jqGrid  分页实体信息
	 */
	private String id;
	private int page;
	private int total;
	private int records;
	private List<?> rows;
	private Map<String,Object> userdata;
	/**
	 * 获得数据行ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置数据行ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获得当前页码
	 */
	public int getPage() {
		return page;
	}
	/**
	 * 设置当前页码
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * 获得总页�? 
	 */
	public int getTotal() {
		if(total==0){
			total=1;
		}
		return total;
	}
	/**
	 * 设置总页�? 
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * 获得数据行�?�数 
	 */
	public int getRecords() {
		return records;
	}
	/**
	 * 设置数据行�?�数 
	 */
	public void setRecords(int records) {
		this.records = records;
	}
	/**
	 * 获得数据列表
	 */
	public List<?> getRows() {
		return rows;
	}
	/**
	 * 设置数据列表
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	/***
	 * 获得自定义数�?
	 */
	public Map<String,Object> getUserdata() {
		if(userdata==null){
			userdata = new HashMap<String,Object>();
		}
		return userdata;
	}
	/***
	 * 设置自定义数�?
	 */
	public void setUserdata(Map<String,Object> userdata) {
		if(userdata == null){
			return;
		}
		this.getUserdata().putAll(userdata);
	}
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void addUserdata(String key,Object value){
		this.getUserdata().put(key, value);
	}
	
}
