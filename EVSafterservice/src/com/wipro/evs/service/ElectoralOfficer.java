/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ElectoralOfficer.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :08-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.service;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */
public interface ElectoralOfficer {

	/**
	 * @param userId String
	 * @param status String
	 * @return String
	 * 
	 *         VoterId should be first 2 letters of user First Name with 2
	 *         letters constituency name followed by 4 digit auto generated
	 *         number
	 */
	String generateVoterId(String userId, String status);

	/**
	 * @return ArrayList<ApplicationBean>
	 */
	ArrayList<ApplicationBean> viewAllVoterIdApplications();

}
