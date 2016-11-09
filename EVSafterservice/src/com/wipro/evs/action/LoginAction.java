/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : LoginAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :04-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.UserImpl;


/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 4, 2014
 */
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * Default serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * session object creation of type SessionMap
	 */
	private SessionMap session;
	private CredentialsBean cb;
	
	
	/**
	 * @return cb
	 */
	public CredentialsBean getCb() {
		return cb;
	}

	/**
	 * @param cb
	 *            object of credentialsbean
	 */
	public void setCb(CredentialsBean cb) {
		this.cb = cb;
	}

	
	/**
	 * @return loginstatus
	 */
	public String login()
	{
        UserImpl userImpl = new UserImpl();
		String s = userImpl.login(cb);
		
		if (!s.equalsIgnoreCase("fail") && !s.equalsIgnoreCase("invalid")) 
		{
			
			session.put("user", cb.getUserID());
			
			if(cb.getUserID().equalsIgnoreCase("admin")&&cb.getPassword().equalsIgnoreCase("0000"))
			{
				return "changeAdmin";
			}
			else if(cb.getUserID().equalsIgnoreCase("EO1001")&&cb.getPassword().equalsIgnoreCase("0000"))
			{
				return "changeEO";
			}
			else if(cb.getUserID().equalsIgnoreCase("EO1002")&&cb.getPassword().equalsIgnoreCase("0000"))
			{
				return "changeEO";
			}
			else if(cb.getUserID().equalsIgnoreCase("EO1003")&&cb.getPassword().equalsIgnoreCase("0000"))
			{
				return "changeEO";
			}
			else
			{	
			  addActionError("Logged in successfully...."+cb.getUserID());	
			  return s;
			}
		} 
		else 
		{   
			addActionError("Username or Password is incorrect..");
			addActionError("Login failure...");
			return s;
		}
	}
	
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

}
