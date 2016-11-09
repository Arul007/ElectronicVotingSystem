/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : VoterImpl.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.ApplicationDAO;
import com.wipro.evs.dao.ApplicationDAOImpl;
import com.wipro.evs.dao.CandidateDAO;
import com.wipro.evs.dao.CandidateDAOImpl;
import com.wipro.evs.dao.ElectionDAO;
import com.wipro.evs.dao.ElectionDAOImpl;
import com.wipro.evs.dao.ProfileDAO;
import com.wipro.evs.dao.ProfileDAOImpl;
import com.wipro.evs.dao.ResultDAOImpl;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

//import evswebservice.VoteCast;
//import evswebservice.VoteCastServiceLocator;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 11, 2014
 */
public class VoterImpl implements Voter {
	
	private static Logger log = Logger.getLogger(VoterImpl.class);
	private Connection con;

	/** 
	 * @see com.wipro.evs.service.Voter#castVote(java.lang.String, java.lang.String, java.lang.String)
	 * @param userId String
	 * @param electionId String
	 * @param candidateId String
	 * @return String
	 */
	public String castVote(String userId, String electionId, String candidateId) 
	{
		try
    	{
    	con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
    	String s1 = "select voterid from evs_tbl_application where userid=?";
		PreparedStatement ps1 = con.prepareStatement(s1);
		ps1.setString(MagicNumber.one, userId);
		ResultSet rs1=ps1.executeQuery();
		if(rs1.next())
		{
			String voterId=rs1.getString(MagicNumber.one);
		String s2 = "select evs_seq_requestid.nextval from dual";
		PreparedStatement ps2 = con.prepareStatement(s2);
		ResultSet rs2 = ps2.executeQuery();
		if (rs2.next()) {
			int i2 = rs2.getInt(1);
			String s3 = "insert into EVS_TBL_Voter_Details values(?,?,?,?)";
			PreparedStatement ps3 = con.prepareStatement(s3);
			ps3.setInt(MagicNumber.one, i2);
			ps3.setString(MagicNumber.two, candidateId);
			ps3.setString(MagicNumber.three, electionId);
			ps3.setString(MagicNumber.four, voterId);
			ps3.executeQuery();

			return "success";
		} else {
			return "error";
		}
		}
		else
		{
			return "error";
		}
	} catch (Exception e) {
        log.error(e);
		return "error";
	}
	finally
	{   try
	   {
		con.setAutoCommit(true);
		con.close();
	   }
	   catch(Exception e)
	   {
		   log.error(e);
	   }
	}
		/*try
		{
		VoteCastServiceLocator vote=new VoteCastServiceLocator();
		VoteCast vc=vote.getVoteCast();
		return vc.vote(userId, electionId, candidateId);
		}
		catch(Exception e)
		{
			log.error(e);
			return "error";
		}*/
    	
	}

	/** 
	 * @see com.wipro.evs.service.Voter#viewCandidatesByElectionName(java.lang.String, java.lang.String)
	 * @param electionName String
	 * @param constituency String
	 * @return ArrayList<CandidateBean>
	 */
	public ArrayList<CandidateBean> viewCandidatesByElectionName(
			String electionName, String constituency) {
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		return candidateDAO.findByElectionIDConstituency(electionName,constituency);
	}

	/** 
	 * @see com.wipro.evs.service.Voter#viewListOfElectionsResults()
	 * @return ArrayList<ResultBean>
	 */
	public ArrayList<ResultBean> viewListOfElectionsResults() {
		ResultDAOImpl result=new ResultDAOImpl();
		return result.findAllResult();
	}

	/** 
	 * @see com.wipro.evs.service.Voter#requestVoterId(java.lang.String)
	 * @param userId String
	 * @return String
	 */
	public String requestVoterId(String userId) {
		ApplicationBean applicationBean=new ApplicationBean();
		ProfileDAO profileDAO=new ProfileDAOImpl();
		ProfileBean profileBean=profileDAO.findByID(userId);
		applicationBean.setConstituency(profileBean.getLocation());
		applicationBean.setUserID(userId);
		ApplicationDAO applicationDAO=new ApplicationDAOImpl();
		return applicationDAO.createApplication(applicationBean);
	}

	/** 
	 * @see com.wipro.evs.service.Voter#viewGeneratedVoterId(java.lang.String, java.lang.String)
	 * @param userId String
	 * @param constituency String
	 * @return String
	 */
	public String viewGeneratedVoterId(String userId, String constituency)
	{
		ApplicationDAO application=new ApplicationDAOImpl();
		String s=application.findByID(userId, constituency);
		return s;
	}

	/** 
	 * @see com.wipro.evs.service.Voter#viewListOfElections()
	 * @return ArrayList
	 */
	public ArrayList<ElectionBean> viewListOfElections() {
		ElectionDAO electionDAO = new ElectionDAOImpl();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return electionDAO.findBy(sqlDate);
	}

}
