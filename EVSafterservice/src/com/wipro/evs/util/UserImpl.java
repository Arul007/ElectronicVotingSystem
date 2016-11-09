/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : UserImpl.java
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
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.dao.ProfileDAO;
import com.wipro.evs.dao.ProfileDAOImpl;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 4, 2014
 */
public class UserImpl implements User {
	private static Logger log = Logger.getLogger(UserImpl.class);
	private Connection con;

	/**
	 * @see com.wipro.evs.util.User#login(com.wipro.evs.bean.CredentialsBean)
	 * @param credentialsBean
	 *            login
	 * @return String
	 * 
	 */

	public String login(CredentialsBean credentialsBean) {
		AuthenticationImpl authenticationImpl = new AuthenticationImpl();
		boolean value = authenticationImpl.authenticate(credentialsBean);
		if (value) {
			log.info("user is authenticated..");
			String userType = authenticationImpl.authorize(credentialsBean
					.getUserID());
			if ((userType.equalsIgnoreCase("A"))
					|| (userType.equalsIgnoreCase("E"))
					|| (userType.equalsIgnoreCase("V"))) {
				boolean b = authenticationImpl.changeLoginStatus(
						credentialsBean, MagicNumber.one);
				if (b) {
					return userType;
				}
			}
		}
		return "invalid";

	}

	/**
	 * @see com.wipro.evs.util.User#logout(java.lang.String)
	 * @param userId
	 *            logout
	 * @return boolean
	 */


	public boolean logout(String userId) {
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserID(userId);
		AuthenticationImpl authenticationImpl = new AuthenticationImpl();
		authenticationImpl.changeLoginStatus(credentialsBean, 0);
		return true;
	}

	/**
	 * @see com.wipro.evs.util.User#register(com.wipro.evs.bean.ProfileBean)
	 * @param profileBean
	 *            for register
	 * @return String
	 */

	public String register(ProfileBean profileBean) {

		ProfileDAO profileDAO = new ProfileDAOImpl();
		String s = profileDAO.createProfile(profileBean);
		return s;

	}

	/**
	 * 
	 * @param credentialsBean
	 *            for ChangePassword
	 * @param newPassword
	 *            String
	 * @return String password
	 */

	public String changePassword(CredentialsBean credentialsBean,
			String newPassword) {

		try {

		    con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
			String s = "UPDATE EVS_TBL_User_Credentials SET Password=? where Userid=?";
			PreparedStatement ps = con.prepareStatement(s);
			String user = (String) ServletActionContext.getRequest()
					.getSession().getAttribute("user");
			ps.setString(MagicNumber.one, newPassword);
			ps.setString(MagicNumber.two, user);
			ps.executeUpdate();
			return "success";
		} catch (Exception e) {
			log.error(e);
			return "fail";
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
