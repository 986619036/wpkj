package com.wpkj.domain;

import java.util.HashMap;


/***
 * 
 * @author zxm
 *
 */
public class ResultMap extends HashMap<String,Object>{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 公共值
	 */
	public static final String MSG="msg";
	public static final String DATA="data";
	public static final String STATE="state";
	
	public ResultMap(){
		//defaut
		this.setState(false);
	}
	
	public ResultMap(boolean state){
		this.setState(state);
	}
	
	public ResultMap(boolean state,Object msg){
		this.setState(state);
		this.setMsg(msg);
	}
	
	public void pure(){
		if(this.containsKey(STATE)){
			this.remove(STATE);
		}
	}
	/**
	 * 设置返回消息
	 * @param object
	 */
	public void setMsg(Object object){
		this.put(MSG, object);
	}
	/***
	 * 设置返回数据
	 * @param list
	 */
	public void setData(Object list){
		this.put(DATA, list);
	}
	/***
	 * 设置返回状态码
	 * @param code
	 */
	public void setState(String code){
		this.put(STATE, code);
	}
	/***
	 * 返回状态码
	 * @param code
	 */
	public String getState(){
		return this.get(STATE).toString();
	}
	/**
	 * 
	 * @return
	 */
	public boolean isSuccess(){
		Object state = this.get(STATE);
		if(state==null){
			return false;
		}else if(state.toString().equals("200")){
			return true;
		}
		return false;
	}
	/***
	 * 
	 * @param state
	 */
	public void setState(boolean state){
		if(state){
			this.setState("200");
		}else{
			this.setState("500");
		}
	}
}
