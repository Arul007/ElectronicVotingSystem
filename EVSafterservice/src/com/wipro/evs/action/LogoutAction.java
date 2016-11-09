/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : LogOutAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :16-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.util.UserImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 16, 2014
 */
public class LogoutAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionMap session;
	
	/**
	 * @return session
	 */
	public SessionMap getSession() {
		return session;
	}

	/**
	 * @param session 
	 */
	@SuppressWarnings("javadoc")
	public void setSession(SessionMap session) {
		this.session = session;
	}

	/**
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 * @param map of type Map
	 */
	public void setSession(@SuppressWarnings("rawtypes") Map map) {
		// TODO Auto-generated method stub
		session = (SessionMap) map;
	}

	

	/**
	 * @return logout status
	 */

	public String logout() {
		UserImpl userImpl = new UserImpl();
		@SuppressWarnings("rawtypes")
		Map map=ActionContext.getContext().getSession();
		String user=(String)map.get("user");
		userImpl.logout(user);
		session.remove("user");
		addActionMessage("Logged out successfully....");
		return SUCCESS;
	}

}
