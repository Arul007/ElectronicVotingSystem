/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : CredentialsBean.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :03-DEC-2014
 * 
 * Modification History:NA
 */
package com.wipro.evs.bean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 3, 2014
 */
public class CredentialsBean
{
    private String userID;
    private String password;
    private String userType;
    private int loginStatus;
    
	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID type String
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password type String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType type String
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return loginStatus
	 */
	public int getLoginStatus() {
		return loginStatus;
	}
	/**
	 * @param loginStatus type Integer
	 */
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	
    
    
    
}
