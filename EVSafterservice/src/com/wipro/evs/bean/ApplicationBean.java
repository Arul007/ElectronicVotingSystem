/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ApplicationBean.java
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
public class ApplicationBean {
	

	private String userID;
	private String constituency;
	private int passedStatus;
	private int approvedStatus;
	private String voterID;
	
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
	 * @return constituency
	 */
	public String getConstituency() {
		return constituency;
	}
	/**
	 * @param constituency type String
	 */
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	/**
	 * @return passedStatus
	 */
	public int getPassedStatus() {
		return passedStatus;
	}
	/**
	 * @param passedStatus type int
	 */
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	/**
	 * @return approvedStatus
	 */
	public int getApprovedStatus() {
		return approvedStatus;
	}
	/**
	 * @param approvedStatus type int
	 */
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	/**
	 * @return voterID
	 */
	public String getVoterID() {
		return voterID;
	}
	/**
	 * @param voterID type String
	 */
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	
	

}
