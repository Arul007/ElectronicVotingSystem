/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : AdminAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :08-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.dao.CandidateDAOImpl;
import com.wipro.evs.dao.ElectionDAO;
import com.wipro.evs.dao.ElectionDAOImpl;
import com.wipro.evs.dao.PartyDAO;
import com.wipro.evs.dao.PartyDAOImpl;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.AdministratorImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {

	//........................................PRIVATE MEMBER DECLARATION........................................
	private ElectionBean electionBean;
	private PartyBean partyBean;
	private PartyBean partyBean1;
    private CandidateBean candidateBean;
	private String electionID;
	private String partyID;
	private String candidateID;
	

	private ArrayList<ElectionBean> s1;
	private ArrayList<ElectionBean> all;
	private ArrayList<PartyBean> allParty;
	private ArrayList<CandidateBean> viewCandidate;
	private ArrayList<CandidateBean> viewCandidateByParty;
	
	//........................................GETTER SETTER FOR electionBean......................................
	/**
	 * @return electionBean
	 */
	public ElectionBean getElectionBean() {
		return electionBean;
	}

	/**
	 * @param electionBean
	 *            ElectionBean
	 */
	public void setElectionBean(ElectionBean electionBean) {
		this.electionBean = electionBean;
	}
	
	//..........................................GETTER SETTER FOR partyBean......................................
	/**
	 * @return partyBean
	 */
	public PartyBean getPartyBean() {
		return partyBean;
	}

	/**
	 * @param partyBean
	 *            PartyBean
	 */
	public void setPartyBean(PartyBean partyBean) {
		this.partyBean = partyBean;
	}
	
	//..........................................GETTER SETTER FOR partyBean1......................................

	/**
	 * @return partyBean1
	 */
	public PartyBean getPartyBean1() {
		return partyBean1;
	}

	/**
	 * @param partyBean1 PartyBean
	 */
	public void setPartyBean1(PartyBean partyBean1) {
		this.partyBean1 = partyBean1;
	}

	//..........................................GETTER SETTER FOR candidateBean......................................
	/**
	 * @return candidateBean
	 */
	public CandidateBean getCandidateBean() {
		return candidateBean;
	}

	/**
	 * @param candidateBean
	 *            CandidateBean
	 */
	public void setCandidateBean(CandidateBean candidateBean) {
		this.candidateBean = candidateBean;
	}
	
	//..........................................GETTER SETTER FOR electionID......................................
	/**
	 * @return electionID
	 */
	public String getElectionID() {
		return electionID;
	}

	/**
	 * @param electionID  String
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	//..........................GETTER SETTER FOR partyID.(view details in modify page)..........................
	/**
	 * @return partyID
	 */
	public String getPartyID() {
		return partyID;
	}

	/**
	 * @param partyID  String
	 */
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}
	
	//.......................................GETTER SETTER FOR partyID (view by partyID)......................................
		/**
		 * @return partyID
		 */
		public String getParty() {
			return partyID;
		}

		/**
		 * @param partyID String
		 */
		public void setParty(String partyID) {
			this.partyID = partyID;
		}

	//..........................................GETTER SETTER FOR candidateID......................................
	/**
	 * @return candidateID
	 */
	public String getCandidateID() {
		return candidateID;
	}

	/**
	 * @param candidateID  String
	 */
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	//..........................GETTER SETTER FOR ArrayList<CandidateBean> viewCandidateByParty......................
	/**
	 * @return viewCandidateByParty
	 */
	public ArrayList<CandidateBean> getViewCandidateByParty() {
		return viewCandidateByParty;
	}

	/**
	 * @param viewCandidateByParty
	 *            CandidateBean
	 */
	public void setViewCandidateByParty(
			ArrayList<CandidateBean> viewCandidateByParty) {
		this.viewCandidateByParty = viewCandidateByParty;
	}

	//......GETTER SETTER FOR ArrayList<CandidateBean> viewCandidate............................
	/**
	 * @return viewCandidate
	 */
	public ArrayList<CandidateBean> getViewCandidate() {
		return viewCandidate;
	}

	/**
	 * @param viewCandidate
	 *            ArrayList<CandidateBean>
	 */
	public void setViewCandidate(ArrayList<CandidateBean> viewCandidate) {
		this.viewCandidate = viewCandidate;
	}

	//.....GETTER SETTER FOR ArrayList<PartyBean> allParty..............................
	/**
	 * @return allParty
	 */
	public ArrayList<PartyBean> getAllParty() {
		return allParty;
	}

	/**
	 * @param allParty
	 *            Array
	 */
	public void setAllParty(ArrayList<PartyBean> allParty) {
		this.allParty = allParty;
	}

	//.....GETTER SETTER FOR ArrayList<ElectionBean> all......................................
	/**
	 * @return all ArrayList<ElectionBean>
	 */
	public ArrayList<ElectionBean> getAll() {
		return all;
	}

	/**
	 * @param all
	 *            ArrayList<ElectionBean>
	 */
	public void setAll(ArrayList<ElectionBean> all) {
		this.all = all;
	}

	

	//....GETTER SETTER FOR ArrayList<ElectionBean> s1......................
	/**
	 * @return s1
	 */
	public ArrayList<ElectionBean> getS1() {
		return s1;
	}

	/**
	 * @param s1
	 *            ArrayList<ElectionBean>
	 */
	public void setS1(ArrayList<ElectionBean> s1) {
		this.s1 = s1;
	}

	

//.....................................Method addElection............................................
	/**
	 * @return String
	 * 
	 */
	public String addElection() {
		Administrator admin = new AdministratorImpl();
		String s = admin.addElection(electionBean);
		addActionMessage("Election Details Added Successfully...");
		return s;
	}

	/**
	 * @return String
	 */
	public String viewAllUpcomingElections() {
		Administrator admin = new AdministratorImpl();
		this.setS1(admin.viewAllUpcomingElections());
		if (s1 != null) {
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * @return String
	 */
	public String viewAllElections() {
		Administrator admin = new AdministratorImpl();
		all = admin.viewElections();
		if (all != null) {
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * @return String
	 */
	public String addParty() {
		Administrator admin = new AdministratorImpl();
		String s = admin.addParty(partyBean);
		addActionMessage("Party Details Added Successfully...");
		return s;
	}

	/**
	 * @return String
	 */
	public String viewAllParty() {
		PartyDAO partyDAO=new PartyDAOImpl();
		allParty = partyDAO.findAll();
		if (allParty != null) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * @return String
	 */
	public String viewAllCandidate() {
		CandidateDAO candidateDAO=new CandidateDAOImpl();
		viewCandidate = candidateDAO.findAll();
		if (viewCandidate != null) {
			return "success";
		} else {
			return "error";
		}
		}
		
		/**
		 * @return String
		 */
		public String viewAllCandidate1() {
			CandidateDAO candidateDAO=new CandidateDAOImpl();
			candidateBean = candidateDAO.findByID(candidateID);
			if (candidateBean != null) {
				return "success";
			} else {
				return "error";
			}
	}

	/**
	 * @return String
	 */
	public String addCandidate() {
		Administrator admin = new AdministratorImpl();
		String s = admin.addCandidate(candidateBean);
		addActionMessage("Candidate Details Added Successfully...");
		return s;
	}

	/**
	 * @return String
	 */
	public String viewCandidateByElection() {
		Administrator admin = new AdministratorImpl();
		viewCandidate = admin.viewCandidateDetailsByElectionName(electionID);
		if (viewCandidate != null) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * @return String
	 */
	public String modifyCandidate() 
	{
	  
		CandidateDAO candidateDAO=new CandidateDAOImpl();
		if(candidateDAO.updateCandidate(candidateBean))
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
	public String viewCandidateByParty() {
		Administrator admin = new AdministratorImpl();
		viewCandidateByParty = admin.viewCandidateDetailsByParty(partyID);
		if (viewCandidateByParty != null) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * @return String
	 */
	public String viewAllElections1() {
		Administrator admin = new AdministratorImpl();
		electionBean = admin.viewElectionById(electionID);
		if (electionBean != null) {
			return "success";
		} else {
			return "error";
		}
	}
	/**
	 * @return String
	 */
	public String modifyElection() 
	{
	  
		ElectionDAO electionDAO=new ElectionDAOImpl();
		if(electionDAO.updateElection(electionBean))
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
	public String deleteElection() 
	{
	  
		ElectionDAO electionDAO=new ElectionDAOImpl();
		ArrayList<String> election=new ArrayList<String>();
		election.add(electionID);
		if(electionDAO.deleteElection(election)==1)
		{
			addActionMessage("Deleted....");
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
	public String deleteCandidate() 
	{
	  
		CandidateDAO candidateDAO=new CandidateDAOImpl();
		ArrayList<String> candidate=new ArrayList<String>();
		candidate.add(candidateID);
		if(candidateDAO.deleteCandidate(candidate)==1)
		{
			addActionMessage("Deleted....");
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
	public String viewAllParty1() {
		
		PartyDAO partyDAO=new PartyDAOImpl();
		this.setPartyBean1(partyDAO.findByID(partyID));
		if (partyBean1 != null) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * @return String
	 */
	public String modifyParty() 
	{
	  
		PartyDAO partyDAO=new PartyDAOImpl();
		if(partyDAO.updateParty(partyBean1))
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
	public String deleteParty() 
	{
	  
		PartyDAO partyDAO=new PartyDAOImpl();
		ArrayList<String> party=new ArrayList<String>();
		party.add(partyID);
		if(partyDAO.deleteParty(party)==1)
		{
			addActionMessage("Deleted....");
			return "success";
		}
		else
		{
			return "error";
		}
	}

}
