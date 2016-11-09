/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : VoterDetailsDAOImpl.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :15-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 15, 2014
 */
public class VoterDetailsDAOImpl {

	private static Logger log = Logger.getLogger(VoterDetailsDAOImpl.class);
	private Connection con;

	/**
	 * @param electionId
	 *            String
	 * @return boolean
	 */
	public String checkVoted(String electionId) {
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			@SuppressWarnings("rawtypes")
			Map map = ActionContext.getContext().getSession();
			String userId = (String) map.get("user");
			ElectionDAOImpl election=new ElectionDAOImpl();
			ElectionBean eb=new ElectionBean();
			eb=election.findByID(electionId);
			String cons=eb.getConstituency();
			ApplicationDAOImpl app = new ApplicationDAOImpl();
			String checkcon=app.checkConstituency(userId, cons);
			if(checkcon.equalsIgnoreCase("success"))
			{	
			String voterId = app.returnVoterId(userId);
			if (!voterId.equalsIgnoreCase("error")) {
				String s = "select voterid from evs_tbl_voter_details where electionid=?";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(MagicNumber.one, electionId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getString(MagicNumber.one).equalsIgnoreCase(voterId)) {
						return "Already Voted...";
					}
				}
				return "success";
			}
			return "error";
		}else
		{
			return "This Election Doesn't belong to your constituency.... You cant't vote";
		}
		}catch (Exception e) {
			log.error(e);
			return "error";
		} finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (Exception e) {
				log.error(e);
			}
		}

	}

}
