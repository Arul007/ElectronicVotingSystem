/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ImpAdminAction.java
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
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.ResultDAOImpl;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.AdministratorImpl;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 11, 2014
 */
public class ImpAdminAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String electionId;
	private ArrayList<ApplicationBean> pendingApplication;
	private ArrayList<ResultBean> result;
	

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
	 * @return electionId
	 */
	public String getElectionId() {
		return electionId;
	}

	/**
	 * @param electionId String
	 */
	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}

	/**
	 * @return pendingApplication
	 */
	public ArrayList<ApplicationBean> getPendingApplication() {
		return pendingApplication;
	}

	/**
	 * @param pendingApplication ArrayList
	 */
	public void setPendingApplication(ArrayList<ApplicationBean> pendingApplication) {
		this.pendingApplication = pendingApplication;
	}

	/**
	 * @return result
	 */
	public ArrayList<ResultBean> getResult() {
		return result;
	}

	/**
	 * @param result ArrayList
	 */
	public void setResult(ArrayList<ResultBean> result) {
		this.result = result;
	}

	/**
	 * @return String
	 */
	public String viewAllAdminPendingApplication()
	{
		Administrator adm=new AdministratorImpl();
		pendingApplication=adm.viewAllAdminPendingApplications();
		if(pendingApplication!=null)
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
	public String forwardRequest()
	{
		Administrator adm=new AdministratorImpl();
		if(adm.forwardVoterIDRequest(userID))
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
	@SuppressWarnings("rawtypes")
	public String approveResult()
	{   
		
		Administrator admin=new AdministratorImpl();
		Map s=new HashMap();
		s=admin.approveElectionResults(electionId);
		if(s.get(MagicNumber.one).toString().equalsIgnoreCase("approved"))
		{
		    ResultDAOImpl rs=new ResultDAOImpl();
		    result=rs.findAllResult();
		    addActionMessage("Approved...!!!!");
			return "success";
		}
		else
		{
			addActionMessage(s.get(MagicNumber.one).toString());
			return "error";
		}
	}
}
