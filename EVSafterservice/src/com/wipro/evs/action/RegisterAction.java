/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : RegisterAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :08-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.UserImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 8, 2014
 */
public class RegisterAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProfileBean profileBean;
	/**
	 * @return profileBean
	 */
	public ProfileBean getProfileBean() {
		return profileBean;
	}
	/**
	 * @param profileBean ProfileBean
	 */
	public void setProfileBean(ProfileBean profileBean) {
		this.profileBean = profileBean;
	}
   /**
 * @return String
 */
public String register()
   {   
       UserImpl userImpl =new UserImpl();
       String s=userImpl.register(profileBean);
       if(s.equalsIgnoreCase("fail"))
       {
    	   return "fail";
       }
       else if(s.equalsIgnoreCase("invalid"))
       {
    	   return "invalid";
       }
       else
       {
   	   addActionMessage("Registration Done Successfully...And UserID is.."+s);
   	   addActionMessage("Login here...");
	   return "success";
       }
   }

}
