package com.wpkj.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 
 * @author Administrator
 *AsyncHandlerInterceptor≥ÈœÛ¿‡
 */
public class CommonInterceptor3 extends HandlerInterceptorAdapter {

	/***
	 * debug
	 */
	private boolean debug = true;
	public boolean isDebug() {  
        return debug;  
    }  
    public void setDebug(boolean debug) {  
        this.debug = debug;  
    }
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
