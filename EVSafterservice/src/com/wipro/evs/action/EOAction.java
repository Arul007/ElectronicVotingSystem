/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : EOAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :11-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.action;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.ApplicationDAOImpl;
import com.wipro.evs.service.ElectoralOfficer;
import com.wipro.evs.service.ElectoralOfficerImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 11, 2014
 */
public class EOAction {

	private String userID;
	private ArrayList<ApplicationBean> pendingEO;
	
	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID String
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return pendingEO
	 */
	public ArrayList<ApplicationBean> getPendingEO() {
		return pendingEO;
	}
	/**
	 * @param pendingEO ArrayList
	 */
	public void setPendingEO(ArrayList<ApplicationBean> pendingEO) {
		this.pendingEO = pendingEO;
	}
	/**
	 * @return String
	 */
	public String viewAllPendingEO()
	{
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		pendingEO=applicationDAO.findAllPendingEO();
		if(pendingEO!=null)
		{
			return "success";
		}
		else
		{
			return "error";
		}
		}
	/**
	 * @return String
	 */
	public String rejectRequest()
	{
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		ApplicationBean applicationBean=new ApplicationBean();
		applicationBean.setUserID(userID);
		if(applicationDAO.updateApplicationReject(applicationBean))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	
	/**
	 * @return String
	 */
	public String approveRequest()
	{
		ElectoralOfficer eo=new ElectoralOfficerImpl();
		String s=eo.generateVoterId(userID, null);
		return s;
		
	}
	}

