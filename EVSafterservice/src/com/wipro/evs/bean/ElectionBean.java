/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ElectionBean.java
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

import java.sql.Date;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 3, 2014
 */
public class ElectionBean 
{
	private String electionID;
	private String name;
	private Date electionDate;
	private String district;
	private String constituency;
	private Date countingDate;
	
	/**
	 * @return electionID
	 */
	public String getElectionID() {
		return electionID;
	}
	/**
	 * @param electionID type String
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name type String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return electionDate
	 */
	public Date getElectionDate() {
		return electionDate;
	}
	/**
	 * @param electionDate type Date
	 */
	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}
	/**
	 * @return district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district type String
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	 * @return countingDate
	 */
	public Date getCountingDate() {
		return countingDate;
	}
	/**
	 * @param countingDate type Date
	 */
	public void setCountingDate(Date countingDate) {
		this.countingDate = countingDate;
	}
	
	

}
