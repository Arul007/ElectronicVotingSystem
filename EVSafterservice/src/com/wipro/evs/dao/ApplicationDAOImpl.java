/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ApplicationDAOImpl.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :11-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 11, 2014
 */
public class ApplicationDAOImpl implements ApplicationDAO {
	
	private static Logger log = Logger.getLogger(ApplicationDAOImpl.class);
	
	private Connection con;

	/**
	 * @see com.wipro.evs.dao.ApplicationDAO#createApplication(com.wipro.evs.bean.ApplicationBean)
	 * @param applicationBean
	 *            ApplicationBean
	 * @return String
	 */
	public String createApplication(ApplicationBean applicationBean) {
			
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
            String s1="select passedstatus,approvedstatus from evs_tbl_application where userid=?";
            PreparedStatement ps1=con.prepareStatement(s1);
            ps1.setString(MagicNumber.one,applicationBean.getUserID());
            ResultSet rs=ps1.executeQuery();
      
            if(!rs.next())
            { 	
			String s = "insert into EVS_TBL_Application values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, applicationBean.getUserID());
			ps.setString(MagicNumber.two, applicationBean.getConstituency());
			ps.setInt(MagicNumber.three, MagicNumber.one);
			ps.setInt(MagicNumber.four, MagicNumber.one);
			ps.setString(MagicNumber.five, null);
			ps.executeQuery();

			    return "SUCCESS";
            }
            else
            {   
            	if((rs.getInt(MagicNumber.one)==MagicNumber.two)||(rs.getInt(MagicNumber.one)==MagicNumber.three))
            	{
            		if(rs.getInt(MagicNumber.two)==MagicNumber.one)
            		{
            			return "APPLIED";
            		}	
            		else
            		{
            			return "REJECTED";
            		}
            	}	
            	else
            	{ 
            		return "APPLIED";
            	}
            }
		} catch (Exception e) {
			log.error(e);
			return "ERROR";
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @see com.wipro.evs.dao.ApplicationDAO#findAllPending()
	 * @return ArrayList
	 */
	public ArrayList<ApplicationBean> findAllPending() {
		ArrayList<ApplicationBean> al = new ArrayList<ApplicationBean>();
		try {
			 con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_application where passedstatus=1";
			PreparedStatement ps = con.prepareStatement(s);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ApplicationBean applicationBean = new ApplicationBean();
				applicationBean.setUserID(rs.getString("userid"));
				applicationBean.setConstituency(rs.getString("constituency"));
				applicationBean.setPassedStatus(rs.getInt("passedstatus"));
				applicationBean.setApprovedStatus(rs.getInt("approvedStatus"));
				applicationBean.setVoterID(rs.getString("voterid"));

				al.add(applicationBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<ApplicationBean> ar = new ArrayList<ApplicationBean>();
			return ar;
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @see com.wipro.evs.dao.ApplicationDAO#updateApplication(com.wipro.evs.bean.ApplicationBean)
	 * @param applicationBean
	 *            ApplicationBean
	 * @return boolean
	 */
	public boolean updateApplication(ApplicationBean applicationBean) {
		try {
			 con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "update evs_tbl_application set passedstatus=2 where userid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, applicationBean.getUserID());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @see com.wipro.evs.dao.ApplicationDAO#updateApplicationEO(com.wipro.evs.bean.ApplicationBean)
	 * @param applicationBean
	 *            ApplicationBean
	 * @return boolean
	 */
	public boolean updateApplicationEO(ApplicationBean applicationBean) {
		try {
			 con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s1="select evs_seq_voterid.nextval from dual";
			PreparedStatement ps = con.prepareStatement(s1);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{	
			Integer i=rs.getInt(1);
			String s2="select constituency from evs_tbl_application where userid=? ";
			PreparedStatement ps2 = con.prepareStatement(s2);
			ps2.setString(MagicNumber.one, applicationBean.getUserID());
			ResultSet rs1=ps2.executeQuery();
			if(rs1.next())
			{
			String s3=rs1.getString(MagicNumber.one);
			String voterid=applicationBean.getUserID().substring(0,MagicNumber.two).toUpperCase().concat(s3.substring(0,MagicNumber.two).toUpperCase().concat(i.toString()));
			String s = "update evs_tbl_application set passedstatus=3,voterid=? where userid=?";
			PreparedStatement ps3 = con.prepareStatement(s);
			ps3.setString(MagicNumber.one,voterid);
			ps3.setString(MagicNumber.two, applicationBean.getUserID());
			ps3.executeUpdate();
			return true;
			}}
			return false;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @see com.wipro.evs.dao.ApplicationDAO#findAllPendingEO()
	 * @return ArrayList
	 */
	public ArrayList<ApplicationBean> findAllPendingEO() {
		ArrayList<ApplicationBean> al = new ArrayList<ApplicationBean>();
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			@SuppressWarnings("rawtypes")
			Map map=ActionContext.getContext().getSession();
			String userId=(String)map.get("user");
			PreparedStatement ps1=con.prepareStatement("select CONSTITUENCY from evs_tbl_eo where ELECTORALOFFICERID=?");
			ps1.setString(1, userId);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
			String s = "select * from evs_tbl_application where passedstatus=2 and approvedstatus=1 and constituency=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, rs1.getString(MagicNumber.one));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ApplicationBean applicationBean = new ApplicationBean();
				applicationBean.setUserID(rs.getString("userid"));
				applicationBean.setConstituency(rs.getString("constituency"));
				applicationBean.setPassedStatus(rs.getInt("passedstatus"));
				applicationBean.setApprovedStatus(rs.getInt("approvedStatus"));
				applicationBean.setVoterID(rs.getString("voterid"));

				al.add(applicationBean);
			}
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<ApplicationBean> ar = new ArrayList<ApplicationBean>();
			return ar;
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @see com.wipro.evs.dao.ApplicationDAO#updateApplicationReject(com.wipro.evs.bean.ApplicationBean)
	 * @param applicationBean
	 *            ApplicationBean
	 * @return boolean
	 */
	public boolean updateApplicationReject(ApplicationBean applicationBean) {
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "update evs_tbl_application set passedstatus=3,approvedstatus=0 where userid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, applicationBean.getUserID());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/** 
	 * @see com.wipro.evs.dao.ApplicationDAO#findByID(java.lang.String, java.lang.String)
	 * @param userId String
	 * @param constituency String
	 * @return String
	 */
	public String findByID(String userId, String constituency) {
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select voterid from evs_tbl_application where userid=? and constituency=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, userId);
			ps.setString(MagicNumber.two, constituency);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getString(MagicNumber.one);
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
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/** 
	 * @see com.wipro.evs.dao.ApplicationDAO#checkVoterId(java.lang.String)
	 * @param userId String
	 * @return String
	 */
	public String checkVoterId(String userId) 
	{
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select voterid from evs_tbl_application where userid=? ";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(MagicNumber.one)!= null)
				{	
				  return "success";
				}
				else
				{
					return "fail1";
				}
			}
			else
			{
				
				return "fail";
			}
			
		} catch (Exception e) {
			log.error(e);
			return "error";
		}
		finally
		{   try
		   {
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}
	
	/**
	 * @param userId String
	 * @return String
	 */
	public String returnVoterId(String userId) 
	{
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select voterid from evs_tbl_application where userid=? ";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(MagicNumber.one)!= null)
				{	
				  return rs.getString(MagicNumber.one);
				}
				else
				{
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
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @param userId String
	 * @return String
	 */
	public String find(String userId) {
		try {
			 con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select voterid from evs_tbl_application where userid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getString(MagicNumber.one);
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
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/** 
	 * @see com.wipro.evs.dao.ApplicationDAO#deleteApplication(java.util.ArrayList)
	 * @param s ArrayList
	 * @return int
	 */
	public int deleteApplication(ArrayList<String> s) {
		return 0;
	}

	/** 
	 * @see com.wipro.evs.dao.ApplicationDAO#findAll()
	 * @return ArrayList
	 */
	public ArrayList<ApplicationBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param userId String
	 * @param constituency String
	 * @return String
	 */
	public String checkConstituency(String userId, String constituency) {
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_application where userid=? and constituency=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, userId);
			ps.setString(MagicNumber.two, constituency);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return "success";
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
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	
}
