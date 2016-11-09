/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : AdministratorImpl.java
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
import java.util.HashMap;
import java.util.Map;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.ApplicationDAOImpl;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.dao.CandidateDAOImpl;
import com.wipro.evs.dao.ElectionDAO;
import com.wipro.evs.dao.ElectionDAOImpl;
import com.wipro.evs.dao.PartyDAO;
import com.wipro.evs.dao.PartyDAOImpl;
import com.wipro.evs.dao.ResultDAOImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */
public class AdministratorImpl implements Administrator {

	/**
	 * @see com.wipro.evs.service.Administrator#addElection(com.wipro.evs.bean.ElectionBean)
	 * @param electionBean
	 *            ElectionBean
	 * @return String
	 */
	public String addElection(ElectionBean electionBean) {
		ElectionDAO electionDAO = new ElectionDAOImpl();
		String s = electionDAO.createElection(electionBean);
		return s;
	}

	/**
	 * @see com.wipro.evs.service.Administrator#viewAllUpcomingElections()
	 * @return ArrayList<ElectionBean>
	 */
	public ArrayList<ElectionBean> viewAllUpcomingElections() {
		ElectionDAO electionDAO = new ElectionDAOImpl();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return electionDAO.findBy(sqlDate);
	}

	/**
	 * @see com.wipro.evs.service.Administrator#viewElections()
	 * @return ArrayList<ElectionBean>
	 */
	public ArrayList<ElectionBean> viewElections() {

		ElectionDAO electionDAO = new ElectionDAOImpl();
		return electionDAO.findAll();
	}

	/**
	 * @see com.wipro.evs.service.Administrator#addParty(com.wipro.evs.bean.PartyBean)
	 * @param partyBean
	 *            PartyBean
	 * @return String
	 */
	public String addParty(PartyBean partyBean) {

		PartyDAO partyDAO = new PartyDAOImpl();
		String s = partyDAO.createParty(partyBean);
		return s;

	}

	/**
	 * @see com.wipro.evs.service.Administrator#viewAllParty()
	 * @return ArrayList<PartyBean>
	 */
	public ArrayList<PartyBean> viewAllParty() {

		PartyDAO partyDAO = new PartyDAOImpl();
		return partyDAO.findAll();
	}

	/**
	 * @see com.wipro.evs.service.Administrator#addCandidate(com.wipro.evs.bean.CandidateBean)
	 * @param candidateBean
	 *            CandidateBean
	 * @return String
	 */
	public String addCandidate(CandidateBean candidateBean) {

		CandidateDAO candidateDAO = new CandidateDAOImpl();
		if(candidateDAO.createCandidate(candidateBean).equalsIgnoreCase("success"))
		{	
			return "success";
		}
		else
		{
		   return "error";
		}   
	}

	/**
	 * @see com.wipro.evs.service.Administrator#viewCandidateDetailsByElectionName(java.lang.String)
	 * @param electionName
	 *            String
	 * @return ArrayList<CandidateBean>
	 */
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(
			String electionName) {
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		return candidateDAO.findByElectionID(electionName);
	}

	/**
	 * @see com.wipro.evs.service.Administrator#viewAllAdminPendingApplications()
	 * @return ArrayList<ApplicationBean>
	 */
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications() {
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		return applicationDAO.findAllPending();
	}

	/**
	 * @see com.wipro.evs.service.Administrator#forwardVoterIDRequest(java.lang.String)
	 * @param userId
	 *            String
	 * @return boolean
	 */
	public boolean forwardVoterIDRequest(String userId) {
		ApplicationBean applicationBean=new ApplicationBean();
		applicationBean.setUserID(userId);
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		return applicationDAO.updateApplication(applicationBean);
	}

	/**
	 * @see com.wipro.evs.service.Administrator#viewCandidateDetailsByParty(java.lang.String)
	 * @param partyId
	 *            String
	 * @return ArrayList<CandidateBean>
	 */
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId) {
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		return candidateDAO.findByPartyID(partyId);
	}

	/**
	 * @see com.wipro.evs.service.Administrator#approveElectionResults(java.lang.String)
	 * @param electionId
	 *            String
	 * @return Map
	 */

	@SuppressWarnings({ "unchecked" })
	public Map<Integer, String> approveElectionResults(String electionId) {
		ResultDAOImpl result=new ResultDAOImpl();
		String s=result.approveElectionResults(electionId);
		@SuppressWarnings("rawtypes")
		Map map=new HashMap();
		map.put(1, s);
	    return map;
	}
	
	
	/**
	 * @param electionId String
	 * @return ElectionBean
	 */
	public ElectionBean viewElectionById(String electionId) {
		ElectionDAO electionDAO = new ElectionDAOImpl();
		
		return electionDAO.findByID(electionId);
	}

}
