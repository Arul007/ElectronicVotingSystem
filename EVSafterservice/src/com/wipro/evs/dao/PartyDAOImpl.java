/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : PartyDAOImpl.java
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */
public class PartyDAOImpl implements PartyDAO {
	private static Logger log = Logger.getLogger(PartyDAOImpl.class);
	private Connection con;

	/**
	 * @see com.wipro.evs.dao.PartyDAO#createParty(com.wipro.evs.bean.PartyBean)
	 * @param partyBean
	 *            PartBean
	 * @return String
	 */

	public String createParty(PartyBean partyBean) {

		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s1 = "select evs_seq_partyId.nextval from dual";
			PreparedStatement ps1 = con.prepareStatement(s1);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				Integer i = rs.getInt(MagicNumber.one);

				String s = "insert into EVS_TBL_Party values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(MagicNumber.one, i.toString());
				ps.setString(MagicNumber.two, partyBean.getName());
				ps.setString(MagicNumber.three, partyBean.getLeader());
				ps.setString(MagicNumber.four, partyBean.getSymbol());
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
	 * @see com.wipro.evs.dao.PartyDAO#findAll()
	 * @return ArrayList<PartyBean>
	 */

	public ArrayList<PartyBean> findAll() {

		ArrayList<PartyBean> al = new ArrayList<PartyBean>();
		try {
		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_party";
			PreparedStatement ps = con.prepareStatement(s);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PartyBean partyBean = new PartyBean();
				partyBean.setPartyID(rs.getString("partyid"));
				partyBean.setName(rs.getString("name"));
				partyBean.setLeader(rs.getString("leader"));
				partyBean.setSymbol(rs.getString("symbol"));

				al.add(partyBean);
			}
			return al;
		} catch (Exception e) {
			log.error(e);
			ArrayList<PartyBean> ar = new ArrayList<PartyBean>();
			return ar;
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
	 * @see com.wipro.evs.dao.PartyDAO#updateParty(com.wipro.evs.bean.PartyBean)
	 * @param partyBean
	 *            PartyBean
	 * @return boolean
	 */

	public boolean updateParty(PartyBean partyBean) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "update evs_tbl_party set partyid=?,name=?,leader=?,symbol=? where partyid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, partyBean.getPartyID());
			ps.setString(MagicNumber.two, partyBean.getName());
			ps.setString(MagicNumber.three, partyBean.getLeader());
			ps.setString(MagicNumber.four, partyBean.getSymbol());
			ps.setString(MagicNumber.five, partyBean.getPartyID());
			ps.executeUpdate();
			return true;
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
	 * @see com.wipro.evs.dao.PartyDAO#findByID(java.lang.String)
	 * @param partyID
	 *            PartyBean
	 * @return String
	 */

	public PartyBean findByID(String partyID) {
		PartyBean partyBean = new PartyBean();
		try {

			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "select * from evs_tbl_party where partyID =?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, partyID);
			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {

				partyBean.setPartyID(rs.getString("partyid"));
				partyBean.setName(rs.getString("name"));
				partyBean.setLeader(rs.getString("leader"));
				partyBean.setSymbol(rs.getString("symbol"));

			}
			
			return partyBean;
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
	 * @see com.wipro.evs.dao.PartyDAO#deleteParty(java.util.ArrayList)
	 * @param party
	 *            ArrayList
	 * @return int
	 */

	public int deleteParty(ArrayList<String> party) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "delete from evs_tbl_party where partyid=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, party.get(0));
			ps.executeUpdate();
			return MagicNumber.one;
		} catch (Exception e) {
			log.error(e);
			return 0;
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

}
