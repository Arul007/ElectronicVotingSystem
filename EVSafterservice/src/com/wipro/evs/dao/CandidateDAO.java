/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : CandidateDAO.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :09-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 9, 2014
 */
public interface CandidateDAO 
{

	   /**
	 * @param candidateBean CandidateBean
	 * @return String
	 */
	String createCandidate(CandidateBean candidateBean);
	     /**
	     * @param electionID String
	     * @return ArrayList
	     */
	 ArrayList<CandidateBean> findByElectionID(String electionID);
	 /**
	 * @param partyID String
	 * @return ArrayList
	 */
	ArrayList<CandidateBean> findByPartyID(String partyID);
	/**
	 * @param candidate 
	 * @return int
	 */
	int deleteCandidate(ArrayList<String> candidate);
	/**
	 * @param candidateBean CandidateBean
	 * @return boolean
	 */
	boolean updateCandidate(CandidateBean candidateBean);
	 /**
	 * @param candidateID String
	 * @return CandidateBean
	 */
	CandidateBean findByID(String candidateID);
	/**
	 * @return ArrayList
	 */
	ArrayList<CandidateBean> findAll();
	 /**
	 * @param electionID String
	 * @param constituency String
	 * @return ArrayList
	 */
	ArrayList<CandidateBean> findByElectionIDConstituency(String electionID,String constituency);
	/**
	 * @param electionID String
	 * @return arrayList
	 */
	ArrayList<CandidateBean> findByJoin(String electionID);
}
