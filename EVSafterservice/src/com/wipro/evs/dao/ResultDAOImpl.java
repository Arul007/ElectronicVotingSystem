/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ResultDAOImpl.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :12-DEC-2014
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
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 12, 2014
 */
public class ResultDAOImpl implements ResultDAO {

	private static Logger log = Logger.getLogger(ResultDAOImpl.class);
	private Connection con;
	
	/**
	 * @see com.wipro.evs.dao.ResultDAO#createResult(com.wipro.evs.bean.ResultBean)
	 * @param resultBean
	 *            ResultBean
	 * @return String
	 */

	public String createResult(ResultBean resultBean) {

		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s1 = "select evs_seq_resultid.nextval from dual";
			PreparedStatement ps1 = con.prepareStatement(s1);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {
				int i = rs1.getInt(1);
				String s = "insert into EVS_TBL_Result values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setInt(MagicNumber.one, i);
				ps.setString(MagicNumber.two, resultBean.getElectionID());
				ps.setString(MagicNumber.three, resultBean.getCandidateID());
				ps.setInt(MagicNumber.four, 0);
				ps.executeQuery();

				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
            log.error(e);
			return "ERROR";
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
	 * @see com.wipro.evs.dao.ResultDAO#updateResult(com.wipro.evs.bean.ResultBean)
	 * @param resultBean
	 *            ResultBean
	 * @return boolean
	 */

	public boolean updateResult(ResultBean resultBean) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s2 = "select evs_seq_requestid.nextval from dual";
			PreparedStatement ps2 = con.prepareStatement(s2);
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				int i2 = rs2.getInt(1);
				String s3 = "insert into EVS_TBL_Voter_Details values(?,?,?,?)";
				PreparedStatement ps3 = con.prepareStatement(s3);
				ApplicationDAOImpl app = new ApplicationDAOImpl();
				@SuppressWarnings("rawtypes")
				Map map = ActionContext.getContext().getSession();
				String userId = (String) map.get("user");
				ps3.setInt(MagicNumber.one, i2);
				ps3.setString(MagicNumber.two, resultBean.getCandidateID());
				ps3.setString(MagicNumber.three, resultBean.getElectionID());
				ps3.setString(MagicNumber.four, app.find(userId));
				ps3.executeQuery();

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
            log.error(e);
			return false;
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
	 * @param ElectionId
	 *            String
	 * @return Map
	 */
	public String approveElectionResults(String ElectionId) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s5 = "select countingdate from evs_tbl_election where electionid=?";
			PreparedStatement ps5 = con.prepareStatement(s5);
			ps5.setString(MagicNumber.one, ElectionId);
			ResultSet rs5 = ps5.executeQuery();
			if (rs5.next()) {
				String s6 = rs5.getDate(MagicNumber.one).toString();
				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				if (s6.equals(sqlDate.toString())) {

					String s = "select distinct candidateid from evs_tbl_voter_details where electionid=?";
					PreparedStatement ps = con.prepareStatement(s);
					ps.setString(MagicNumber.one, ElectionId);
					ResultSet rs = ps.executeQuery();
					int i = 0;
					while(rs.next()) 
					{
						i=i+MagicNumber.one;
					}

					if (i >= MagicNumber.two) {

						String s1 = "select distinct candidateid from evs_tbl_voter_details where electionid=?";
						PreparedStatement ps1 = con.prepareStatement(s1);
						ps1.setString(MagicNumber.one, ElectionId);
						ResultSet rs1 = ps1.executeQuery();

						while (rs1.next()) {

							String s2 = "select count(voterid) from evs_tbl_voter_Details where candidateid=?";
							PreparedStatement ps2 = con.prepareStatement(s2);
							ps2.setString(MagicNumber.one,
									rs1.getString(MagicNumber.one));
							ResultSet rs2 = ps2.executeQuery();

							while (rs2.next()) {
							
								if (rs2.getInt(MagicNumber.one) >= MagicNumber.ten) {
									
									String s7="select * from evs_tbl_result where electionid=? and candidateid=?";
									PreparedStatement ps7=con.prepareStatement(s7);
									ps7.setString(MagicNumber.one, ElectionId);
									ps7.setString(MagicNumber.two, rs1.getString(MagicNumber.one));
									ResultSet rs7=ps7.executeQuery();
									if(!rs7.next())
									{	
									  String s3 = "insert into evs_tbl_result values(evs_seq_resultid.nextval,?,?,?)";
									  PreparedStatement ps3 = con
											.prepareStatement(s3);

									ps3.setString(MagicNumber.one, ElectionId);
									ps3.setString(MagicNumber.two,
											rs1.getString(MagicNumber.one));
									ps3.setInt(MagicNumber.three,
											rs2.getInt(MagicNumber.one));
									ps3.executeUpdate();
									}
									else
									{
										return "Already Approved....!!";
									}
								}
							}
						}
						return "approved";
					} else {
						return "No of Candidates Less than Two...";
					}

				} else {
					return "Counting Date is not Today...";
				}

			} else {
				return "Election does not Exist";
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
	 * @return ArrayList
	 */
	public ArrayList<ResultBean> findAllResult() {
		ArrayList<ResultBean> al = new ArrayList<ResultBean>();
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_result";
			PreparedStatement ps = con.prepareStatement(s);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ResultBean resultBean = new ResultBean();
				resultBean.setSerialNo(rs.getInt("serialno"));
				resultBean.setElectionID(rs.getString("electionid"));
				resultBean.setCandidateID(rs.getString("candidateid"));
				resultBean.setVoteCount(rs.getInt("votecount"));

				al.add(resultBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			return null;
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
	 * @see com.wipro.evs.dao.ResultDAO#findAll()
	 * @return ArrayList
	 */

	public ArrayList<ResultBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
