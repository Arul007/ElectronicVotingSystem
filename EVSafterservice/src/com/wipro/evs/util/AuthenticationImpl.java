/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : AuthenticationImpl.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :04-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.wipro.evs.bean.CredentialsBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 4, 2014
 */
public class AuthenticationImpl implements Authentication {
	
	private static Connection con;
	private static Logger log = Logger.getLogger(AuthenticationImpl.class);
	
     /**
	 * @see com.wipro.evs.util.Authentication#authenticate(com.wipro.evs.bean.CredentialsBean)
	 * @param user
	 *            CredentialsBean
	 * @return Authentication
	 */
	public boolean authenticate(CredentialsBean user) {
		log.info("starting authentication....");
		String s = "select * from EVS_TBL_User_Credentials where Userid=? and Password=?";
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, user.getUserID());
			ps.setString(MagicNumber.two, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		finally
		{
			try
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
	 * @see com.wipro.evs.util.Authentication#authorize(java.lang.String)
	 * @param userId
	 *            String
	 * @return authorize
	 */
	public String authorize(String userId) {
		String s = "select userType from EVS_TBL_User_Credentials where Userid=?";
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(MagicNumber.one, userId);
			ResultSet rs = ps.executeQuery();
			log.info("executed authorize...");
			if (rs.next()) {
				log.info("rs.next is true and returning");
				return rs.getString(MagicNumber.one);
			} else {
				log.info("returning null...");
				return null;
			}
		} catch (Exception e) {
			log.error(e);
			return "fail";
		} finally {
			try {
				con.close();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}

	/**
	 * @see com.wipro.evs.util.Authentication#changeLoginStatus(com.wipro.evs.bean.CredentialsBean,
	 *      int)
	 * @param user
	 *            CredentialsBean
	 * @param loginStatus
	 *            integer
	 * @return boolean
	 */
	public boolean changeLoginStatus(CredentialsBean user, int loginStatus) {
		String s = "UPDATE EVS_TBL_User_Credentials SET LOGINSTATUS=? WHERE USERID=?";
		try {
			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			PreparedStatement ps= con.prepareStatement(s);
			ps.setInt(MagicNumber.one, loginStatus);
			ps.setString(MagicNumber.two, user.getUserID());
			ps.executeUpdate();
			return true;
		} catch (Exception e) 
		{
			log.error(e);
			return false;
		}
		finally
		{
			try
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
