/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ElectionDAOImpl.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :08-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */
public class ElectionDAOImpl implements ElectionDAO {

	private static Logger log = Logger.getLogger(ElectionDAOImpl.class);
	private Connection con;

	/**
	 * @see com.wipro.evs.dao.ElectionDAO#createElection(com.wipro.evs.bean.ElectionBean)
	 * @param electionBean
	 *            ElectionBean
	 * @return String
	 */
	
	public String createElection(ElectionBean electionBean) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s1 = "select evs_seq_electionId.nextval from dual";
			PreparedStatement ps1 = con.prepareStatement(s1);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				Integer i = rs.getInt(MagicNumber.one);
				String s = "insert into EVS_TBL_Election values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(MagicNumber.one, i.toString());
				ps.setString(MagicNumber.two, electionBean.getName());
				ps.setDate(MagicNumber.three, electionBean.getElectionDate());
				ps.setString(MagicNumber.four, electionBean.getDistrict());
				ps.setString(MagicNumber.five, electionBean.getConstituency());
				ps.setDate(MagicNumber.six, electionBean.getCountingDate());
				ps.executeQuery();
				return "success";
			} else {
				return "fail";
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

	}

	/**
	 * @see com.wipro.evs.dao.ElectionDAO#findByID(java.sql.Date)
	 * @param date
	 *            Date
	 * @return ArrayList<ElectionBean>
	 */
	

	public ArrayList<ElectionBean> findBy(Date date) {
		ArrayList<ElectionBean> al = new ArrayList<ElectionBean>();
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_election where ElectionDate >?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setDate(MagicNumber.one, date);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ElectionBean electionBean = new ElectionBean();
				electionBean.setElectionID(rs.getString("electionid"));
				electionBean.setName(rs.getString("name"));
				electionBean.setConstituency(rs.getString("constituency"));
				electionBean.setElectionDate(rs.getDate("electiondate"));
				electionBean.setDistrict(rs.getString("district"));
				electionBean.setCountingDate(rs.getDate("countingdate"));

				al.add(electionBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<ElectionBean> ar = new ArrayList<ElectionBean>();
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
	 * @see com.wipro.evs.dao.ElectionDAO#findAll()
	 * @return ArrayList<ElectionBean>
	 */

	public ArrayList<ElectionBean> findAll() {

		ArrayList<ElectionBean> al = new ArrayList<ElectionBean>();
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_election";
			PreparedStatement ps = con.prepareStatement(s);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ElectionBean electionBean = new ElectionBean();
				electionBean.setElectionID(rs.getString("electionid"));
				electionBean.setName(rs.getString("name"));
				electionBean.setConstituency(rs.getString("constituency"));
				electionBean.setElectionDate(rs.getDate("electiondate"));
				electionBean.setDistrict(rs.getString("district"));
				electionBean.setCountingDate(rs.getDate("countingdate"));

				al.add(electionBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<ElectionBean> ar = new ArrayList<ElectionBean>();
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
	 * @see com.wipro.evs.dao.ElectionDAO#findByID(java.lang.String)
	 * @param electionID
	 *            String
	 * @return ElectionBean
	 */

	public ElectionBean findByID(String electionID) {
		ElectionBean electionBean = new ElectionBean();
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_election where ElectionID =?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, electionID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				electionBean.setElectionID(rs.getString("electionid"));
				electionBean.setName(rs.getString("name"));
				electionBean.setConstituency(rs.getString("constituency"));
				electionBean.setElectionDate(rs.getDate("electiondate"));
				electionBean.setDistrict(rs.getString("district"));
				electionBean.setCountingDate(rs.getDate("countingdate"));

			}
			return electionBean;
		} catch (Exception e) {
			log.error(e);

			return null;
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
	 * @see com.wipro.evs.dao.ElectionDAO#updateElection(com.wipro.evs.bean.ElectionBean)
	 * @param electionBean
	 *            ElectionBean
	 * @return boolean
	 */

	public boolean updateElection(ElectionBean electionBean) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "update evs_tbl_election set electionid=?,name=?,electiondate=?,district=?,constituency=?,countingdate=? where electionid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, electionBean.getElectionID());
			ps.setString(MagicNumber.two, electionBean.getName());
			ps.setDate(MagicNumber.three, electionBean.getElectionDate());
			ps.setString(MagicNumber.four, electionBean.getDistrict());
			ps.setString(MagicNumber.five, electionBean.getConstituency());
			ps.setDate(MagicNumber.six, electionBean.getCountingDate());
			ps.setString(MagicNumber.seven, electionBean.getElectionID());
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
	 * @see com.wipro.evs.dao.ElectionDAO#deleteElection(java.util.ArrayList)
	 * @param election
	 *            ArrayList
	 * @return int
	 */

	public int deleteElection(ArrayList<String> election) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "delete from evs_tbl_election where electionid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, election.get(0));
			ps.executeUpdate();
			return MagicNumber.one;
		} catch (Exception e) {
			log.error(e);
			return 0;
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
	 * @param electionId
	 *            String
	 * @return boolean
	 */
	public boolean checkDate(String electionId) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select electiondate from evs_tbl_election where electionid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, electionId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				if (rs.getDate(MagicNumber.one).toString()
						.equals(sqlDate.toString())) {
					return true;
				} else {
					return false;
				}
			}
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

}
