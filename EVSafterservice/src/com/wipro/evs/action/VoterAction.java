/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : VoterAction.java
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
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.ApplicationDAOImpl;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.dao.CandidateDAOImpl;
import com.wipro.evs.dao.ElectionDAOImpl;
import com.wipro.evs.dao.VoterDetailsDAOImpl;
import com.wipro.evs.service.Voter;
import com.wipro.evs.service.VoterImpl;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 11, 2014
 */
public class VoterAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String electionID;
	private String constituency;
	private String candidateID;
	private ArrayList<ElectionBean> listOfElection;
	private ArrayList<CandidateBean> listOfCandidate;
	private ArrayList<CandidateBean> listOfCandidate1;
	private ArrayList<ApplicationBean> view;
	private ArrayList<ResultBean> result;
	
	/**
	 * @return candidateID
	 */
	public String getCandidateID() {
		return candidateID;
	}

	/**
	 * @param candidateID String
	 */
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	/**
	 * @return listOfCandidate1
	 */
	public ArrayList<CandidateBean> getListOfCandidate1() {
		return listOfCandidate1;
	}

	/**
	 * @param listOfCandidate1 ArrayList
	 */
	public void setListOfCandidate1(ArrayList<CandidateBean> listOfCandidate1) {
		this.listOfCandidate1 = listOfCandidate1;
	}

	/**
	 * @return electionID
	 */
	public String getElectionID() {
		return electionID;
	}

	/**
	 * @param electionID String
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	/**
	 * @return constituency
	 */
	public String getConstituency() {
		return constituency;
	}

	/**
	 * @param constituency String
	 */
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	/**
	 * @return listOfElection
	 */
	public ArrayList<ElectionBean> getListOfElection() {
		return listOfElection;
	}

	/**
	 * @param listOfElection  ArrayList
	 */
	public void setListOfElection(ArrayList<ElectionBean> listOfElection) {
		this.listOfElection = listOfElection;
	}

	/**
	 * @return listOfCandidate
	 */
	public ArrayList<CandidateBean> getListOfCandidate() {
		return listOfCandidate;
	}

	/**
	 * @param listOfCandidate ArrayList
	 */
	public void setListOfCandidate(ArrayList<CandidateBean> listOfCandidate) {
		this.listOfCandidate = listOfCandidate;
	}

	/**
	 * @return view
	 */
	public ArrayList<ApplicationBean> getView() {
		return view;
	}

	/**
	 * @param view ArrayList
	 */
	public void setView(ArrayList<ApplicationBean> view) {
		this.view = view;
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
	@SuppressWarnings("rawtypes")
	public String requestVoterID()
	{
		Map map=ActionContext.getContext().getSession();
		String userId=(String)map.get("user");
		Voter voter=new VoterImpl();
		String s=voter.requestVoterId(userId);
		if(s.equalsIgnoreCase("success"))
		{
			addActionMessage("Applied Successfully..");
			return "success";
		}
		else if(s.equalsIgnoreCase("applied"))
		{
			addActionMessage("Already Applied....");
		return "success";
		}
		else if(s.equalsIgnoreCase("Rejected"))
		{
			addActionMessage("Application Rejected...");
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
	public String viewListOfElections()
	{
		Voter voter=new VoterImpl();
		listOfElection=voter.viewListOfElections();
		if(listOfElection!=null)
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
	public String viewCandidateByElectionVoter()
	{
		Voter voter=new VoterImpl();
		listOfCandidate=voter.viewCandidatesByElectionName(electionID, constituency);
		if(listOfCandidate!=null)
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}

	/** 
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 * @param arg0 Map
	 */
	@SuppressWarnings("rawtypes")
	public void setSession(Map arg0) {
		
		
	}
	
	/**
	 * @return String
	 */
	public String viewGeneratedID()
	{
		Voter voter=new VoterImpl();
		@SuppressWarnings("rawtypes")
		Map map=ActionContext.getContext().getSession();
		String userId=(String)map.get("user");
		String s=voter.viewGeneratedVoterId(userId, constituency);
		if(s!=null)
		{	
		if(s.equalsIgnoreCase("error"))
		{   
			addActionError("Error Occured Try Again with Correct Constituency...!!");
			return "error";
		}
		else
		{
			addActionMessage("The VoterID is...."+s);
			return "success";
		}}
		else
		{
			addActionError("Voter Id is Not Generated...!!");
			return "fail";
		}
	}
	
    /**
     * @return String
     */
    public String castVote()
    {
    	@SuppressWarnings("rawtypes")
		Map map=ActionContext.getContext().getSession();
		String userId=(String)map.get("user");
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		String s=applicationDAO.checkVoterId(userId);
		if(s.equalsIgnoreCase("success"))
		{
			
			return s;
		}
		else if(s.equalsIgnoreCase("fail1"))
		{
			addActionMessage("You are not having a valid ID");
			return s;
		}
		else
		{
		addActionMessage("Error occured...");
		return s;
		}
    }
    
	/**
	 * @return String
	 */
	public String voting() {
		ElectionDAOImpl election = new ElectionDAOImpl();
		VoterDetailsDAOImpl voter = new VoterDetailsDAOImpl();
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		if (election.checkDate(electionID)) {
			String s=voter.checkVoted(electionID);
			if (s.equalsIgnoreCase("success")) {
				
				listOfCandidate1 = candidateDAO.findByJoin(electionID);
				if (listOfCandidate1 != null) {

					return "success";
				} else {
					return "error";
				}
			} else {
				addActionError(s);
				return "fail";
			}
		} else {
			addActionError("Election Date is Not today.......");
			return "fail";
		}
	}
    /**
     * @return String
     */
    public String vote()
    {
    	Voter vot=new VoterImpl();
    	VoterDetailsDAOImpl voter = new VoterDetailsDAOImpl();
    	@SuppressWarnings("rawtypes")
		Map map = ActionContext.getContext().getSession();
		String userId = (String) map.get("user");
    	String s=voter.checkVoted(electionID);
		if (s.equalsIgnoreCase("success")) {
    	if(vot.castVote(userId, electionID, candidateID).equalsIgnoreCase("success"))
    	{
    		addActionMessage("Voted successfully.....");
    		return "success";
    	}
    	else
    	{ 
    		return "error";
    	}
		}
		else
		{
			addActionMessage("Already voted...");
			return "error";
		}
    }
    
    /**
     * @return String
     */
    public String electionResult()
    {
    	Voter voter=new VoterImpl();
		result=voter.viewListOfElectionsResults();
		if(!result.isEmpty())
		{ 
			return "success";
		}	
		else
		{  
			addActionMessage("The Result is not Published");
			return "error";
		}	
		
		
    }
}


