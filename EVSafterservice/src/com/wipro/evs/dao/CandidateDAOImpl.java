/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : CandidateDAOImpl.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 9, 2014
 */
public class CandidateDAOImpl implements CandidateDAO {

	private static Logger log = Logger.getLogger(CandidateDAOImpl.class);
    private Connection con;
	/**
	 * @see com.wipro.evs.dao.CandidateDAO#createCandidate(com.wipro.evs.bean.CandidateBean)
	 * @param candidateBean
	 *            CandidateBean
	 * @return String
	 */
	
	public String createCandidate(CandidateBean candidateBean) {

		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s1 = "select evs_seq_candidateId.nextval from dual";
			PreparedStatement ps1 = con.prepareStatement(s1);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				Integer i = rs.getInt(MagicNumber.one);
				String s = "insert into EVS_TBL_Candidate values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(MagicNumber.one, i.toString());
				ps.setString(MagicNumber.two, candidateBean.getName());
				ps.setString(MagicNumber.three, candidateBean.getElectionID());
				ps.setString(MagicNumber.four, candidateBean.getPartyID());
				ps.setString(MagicNumber.five, candidateBean.getDistrict());
				ps.setString(MagicNumber.six, candidateBean.getConstituency());
				ps.setDate(MagicNumber.seven, candidateBean.getDateOfBirth());
				ps.setString(MagicNumber.eight, candidateBean.getMobileNo());
				ps.setString(MagicNumber.nine, candidateBean.getAddress());
				ps.setString(MagicNumber.ten, candidateBean.getEmailID());
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
			con.close();
		   }
		   catch(Exception e)
		   {
			   log.error(e);
		   }
		}
	}

	/**
	 * @see com.wipro.evs.dao.CandidateDAO#findByElectionID(java.lang.String)
	 * @param electionID
	 *            Candidate
	 * @return ArrayList
	 */
	public ArrayList<CandidateBean> findByElectionID(String electionID) {

		ArrayList<CandidateBean> al = new ArrayList<CandidateBean>();
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_candidate where electionId=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, electionID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CandidateBean candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rs.getString("candidateid"));
				candidateBean.setName(rs.getString("name"));
				candidateBean.setElectionID(rs.getString("electionid"));
				candidateBean.setPartyID(rs.getString("partyid"));
				candidateBean.setDistrict(rs.getString("district"));
				candidateBean.setConstituency(rs.getString("constituency"));
				candidateBean.setDateOfBirth(rs.getDate("dateofbirth"));
				candidateBean.setMobileNo(rs.getString("mobileno"));
				candidateBean.setAddress(rs.getString("address"));
				candidateBean.setEmailID(rs.getString("emailid"));

				al.add(candidateBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<CandidateBean> ar = new ArrayList<CandidateBean>();
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
	 * @see com.wipro.evs.dao.CandidateDAO#findByPartyID(java.lang.String)
	 * @param partyID
	 *            String
	 * @return ArrayList
	 */
	
	public ArrayList<CandidateBean> findByPartyID(String partyID) {
		ArrayList<CandidateBean> al = new ArrayList<CandidateBean>();
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_candidate where partyId=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, partyID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CandidateBean candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rs.getString("candidateid"));
				candidateBean.setName(rs.getString("name"));
				candidateBean.setElectionID(rs.getString("electionid"));
				candidateBean.setPartyID(rs.getString("partyid"));
				candidateBean.setDistrict(rs.getString("district"));
				candidateBean.setConstituency(rs.getString("constituency"));
				candidateBean.setDateOfBirth(rs.getDate("dateofbirth"));
				candidateBean.setMobileNo(rs.getString("mobileno"));
				candidateBean.setAddress(rs.getString("address"));
				candidateBean.setEmailID(rs.getString("emailid"));

				al.add(candidateBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<CandidateBean> ar = new ArrayList<CandidateBean>();
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
	 * @see com.wipro.evs.dao.CandidateDAO#deleteCandidate(java.util.ArrayList)
	 * @param candidate
	 *            ArrayList
	 * @return int
	 */

	public int deleteCandidate(ArrayList<String> candidate) {
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "delete from evs_tbl_candidate where candidateid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, candidate.get(0));
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
	 * @see com.wipro.evs.dao.CandidateDAO#updateCandidate(com.wipro.evs.bean.CandidateBean)
	 * @param candidateBean
	 *            CandidateBean
	 * @return boolean
	 */
	public boolean updateCandidate(CandidateBean candidateBean) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "update evs_tbl_candidate set candidateid=?,name=?,electionid=?,partyid=?,district=?,constituency=?,dateofbirth=?,mobileno=?,address=?,emailid=? where candidateid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, candidateBean.getCandidateID());
			ps.setString(MagicNumber.two, candidateBean.getName());
			ps.setString(MagicNumber.three, candidateBean.getElectionID());
			ps.setString(MagicNumber.four, candidateBean.getPartyID());
			ps.setString(MagicNumber.five, candidateBean.getDistrict());
			ps.setString(MagicNumber.six, candidateBean.getConstituency());
			ps.setDate(MagicNumber.seven, candidateBean.getDateOfBirth());
			ps.setString(MagicNumber.eight, candidateBean.getMobileNo());
			ps.setString(MagicNumber.nine, candidateBean.getAddress());
			ps.setString(MagicNumber.ten, candidateBean.getEmailID());
			ps.setString(MagicNumber.eleven, candidateBean.getCandidateID());
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
	 * @see com.wipro.evs.dao.CandidateDAO#findAll()
	 * @return ArrayList
	 */
	
	public ArrayList<CandidateBean> findAll() {
		ArrayList<CandidateBean> al = new ArrayList<CandidateBean>();
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_candidate";
			PreparedStatement ps = con.prepareStatement(s);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CandidateBean candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rs.getString("candidateid"));
				candidateBean.setName(rs.getString("name"));
				candidateBean.setElectionID(rs.getString("electionid"));
				candidateBean.setPartyID(rs.getString("partyid"));
				candidateBean.setDistrict(rs.getString("district"));
				candidateBean.setConstituency(rs.getString("constituency"));
				candidateBean.setDateOfBirth(rs.getDate("dateofbirth"));
				candidateBean.setMobileNo(rs.getString("mobileno"));
				candidateBean.setAddress(rs.getString("address"));
				candidateBean.setEmailID(rs.getString("emailid"));

				al.add(candidateBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<CandidateBean> ar = new ArrayList<CandidateBean>();
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
	 * @see com.wipro.evs.dao.CandidateDAO#findByID(java.lang.String)
	 * @param candidateID
	 *            String
	 * @return CandidateBean
	 */
	
	public CandidateBean findByID(String candidateID) {
		CandidateBean candidateBean = new CandidateBean();
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_candidate where candidateid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, candidateID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				candidateBean.setCandidateID(rs.getString("candidateid"));
				candidateBean.setName(rs.getString("name"));
				candidateBean.setElectionID(rs.getString("electionid"));
				candidateBean.setPartyID(rs.getString("partyid"));
				candidateBean.setDistrict(rs.getString("district"));
				candidateBean.setConstituency(rs.getString("constituency"));
				candidateBean.setDateOfBirth(rs.getDate("dateofbirth"));
				candidateBean.setMobileNo(rs.getString("mobileno"));
				candidateBean.setAddress(rs.getString("address"));
				candidateBean.setEmailID(rs.getString("emailid"));
			}
			return candidateBean;
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
	 * @see com.wipro.evs.dao.CandidateDAO#findByElectionIDConstituency(java.lang.String,
	 *      java.lang.String)
	 * @param electionID
	 *            String
	 * @param constituency
	 *            String
	 * @return ArrayList
	 */

	public ArrayList<CandidateBean> findByElectionIDConstituency(
			String electionID, String constituency) {
		ArrayList<CandidateBean> al = new ArrayList<CandidateBean>();
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_candidate where electionId=? and constituency=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, electionID);
			ps.setString(MagicNumber.two, constituency);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CandidateBean candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rs.getString("candidateid"));
				candidateBean.setName(rs.getString("name"));
				candidateBean.setElectionID(rs.getString("electionid"));
				candidateBean.setPartyID(rs.getString("partyid"));
				candidateBean.setDistrict(rs.getString("district"));
				candidateBean.setConstituency(rs.getString("constituency"));
				candidateBean.setDateOfBirth(rs.getDate("dateofbirth"));
				candidateBean.setMobileNo(rs.getString("mobileno"));
				candidateBean.setAddress(rs.getString("address"));
				candidateBean.setEmailID(rs.getString("emailid"));

				al.add(candidateBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<CandidateBean> ar = new ArrayList<CandidateBean>();
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
	 * @param electionID String
	 * @return ArrayList
	 */
    
	public ArrayList<CandidateBean> findByJoin(String electionID) {

		ArrayList<CandidateBean> al = new ArrayList<CandidateBean>();
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select evs_tbl_candidate.candidateid,evs_tbl_candidate.name,evs_tbl_party.name,evs_tbl_party.symbol,evs_tbl_candidate.electionid from evs_tbl_candidate inner join evs_tbl_party on evs_tbl_candidate.partyid=evs_tbl_party.partyid where electionId=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, electionID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CandidateBean candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rs.getString(MagicNumber.one));
				candidateBean.setName(rs.getString(MagicNumber.two));
				candidateBean.setPartyName(rs.getString(MagicNumber.three));
				candidateBean.setSymbol(rs.getString(MagicNumber.four));
				candidateBean.setElectionID(rs.getString(MagicNumber.five));
				al.add(candidateBean);
			}
			return al;
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
}
