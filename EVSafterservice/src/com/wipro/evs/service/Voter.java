/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : Voter.java
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

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 8, 2014
 */
public interface Voter
{
	/**
	 * @param userId String
	 * @param electionId String
	 * @param candidateId String
	 * @return String
	 */
	//Return value must be either: "SUCCESS", "FAIL", “ALREADY CASTED”
			String castVote(String userId, String electionId, String candidateId);
			
		 /**
		 * @param electionName String
		 * @param constituency String
		 * @return arraylist
		 */
		ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName, String constituency);
		 
		 /**
		 * @return arrayllist
		 */
		ArrayList<ResultBean> viewListOfElectionsResults();
		 
		//Return value must be either: "SUCCESS", "FAIL", “APPLIED”, “REJECTED” Note: Applied-> Application is pending with EO or Admin, Rejected-> Application rejected by EO String viewGeneratedVoterId(String userId, String constituency) Return value must be either:"<8 character voterId>", "FAIL", “PENDING”, “REJECTED” ArrayList<ElectionBean> viewListOfElections()
		 /**
		 * @param userId String
		 * @return string
		 */
		String requestVoterId(String userId);
		/**
		 * @param userId String
		 * @param constituency String
		 * @return String
		 */
		String viewGeneratedVoterId(String userId,String constituency);
		/**
		 * @return ArrayList
		 */
		ArrayList<ElectionBean>viewListOfElections();
}
