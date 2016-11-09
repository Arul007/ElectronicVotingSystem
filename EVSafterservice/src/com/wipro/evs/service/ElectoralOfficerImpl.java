/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ElectoralOfficerImpl.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :11-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.service;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.ApplicationDAOImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 11, 2014
 */
public class ElectoralOfficerImpl implements ElectoralOfficer {

	/** 
	 * @see com.wipro.evs.service.ElectoralOfficer#generateVoterId(java.lang.String, java.lang.String)
	 * @param userId String
	 * @param status String
	 * @return String
	 */
	public String generateVoterId(String userId, String status) {
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		ApplicationBean applicationBean=new ApplicationBean();
		applicationBean.setUserID(userId);
		if(applicationDAO.updateApplicationEO(applicationBean))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}

	/** 
	 * @see com.wipro.evs.service.ElectoralOfficer#viewAllVoterIdApplications()
	 * @return ArrayList
	 */
	public ArrayList<ApplicationBean> viewAllVoterIdApplications() {
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		return applicationDAO.findAllPendingEO();
	}

}
