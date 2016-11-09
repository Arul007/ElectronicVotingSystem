/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ChangePasswordAction.java
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

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.UserImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 16, 2014
 */
public class ChangePasswordAction extends ActionSupport
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CredentialsBean cb;
	private String newpass;
	private String connewpass; 
	
	/**
	 * @return cb
	 */
	public CredentialsBean getCb() {
		return cb;
	}

	/**
	 * @param cb  Credentials Bean
	 */
	public void setCb(CredentialsBean cb) {
		this.cb = cb;
	}

	/**
	 * @return newpass
	 */
	public String getNewpass() {
		return newpass;
	}

	/**
	 * @param newpass String
	 */
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	/**
	 * @return connewpass
	 */
	public String getConnewpass() {
		return connewpass;
	}

	/**
	 * @param connewpass String
	 */
	public void setConnewpass(String connewpass) {
		this.connewpass = connewpass;
	}

	/**
	 * @return String
	 */
	public String changePassword()
	{
		
		UserImpl userImpl =new UserImpl();
		if(newpass.equals(connewpass))
		{
		String s=userImpl.changePassword(cb, newpass);
		
		if(s.equalsIgnoreCase("success"))
		{   
			addActionMessage("Password Changed Successfully....!!");
			return s;
		}
		else
		{
			addActionError("Problem Occured Try Again....!!");
			return s;
		}		
		}
		else
		{
			return "invalid";
		}
	}
}
