/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ProfileDAOImpl.java
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

import org.apache.log4j.Logger;

import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.MagicNumber;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */
public class ProfileDAOImpl implements ProfileDAO {

	private static Logger log = Logger.getLogger(ProfileDAOImpl.class);
	private Connection con;

	/**
	 * @see com.wipro.evs.dao.ProfileDAO#createProfile(com.wipro.evs.bean.ProfileBean)
	 * @param profileBean
	 *            ProfileBean
	 * @return String
	 */

	public String createProfile(ProfileBean profileBean) {

		try {

			con = DBUtil.getDBConnection("oracle.jdbc.OracleDriver");

			Integer i=0;
			String s1 = "select evs_seq_userid.nextval from dual";
			PreparedStatement ps = con.prepareStatement(s1);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				i = rs.getInt(MagicNumber.one);

				String userid = profileBean.getFirstName().substring(0, MagicNumber.two).toUpperCase()
						.concat(i.toString());

				String s2 = "insert into EVS_TBL_User_Credentials values(?,?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(s2);
				ps2.setString(MagicNumber.one, userid);
				ps2.setString(MagicNumber.two, profileBean.getPassword());
				ps2.setString(MagicNumber.three, "V");
				ps2.setInt(MagicNumber.four, 0);
				ps2.executeQuery();

				String s = "insert into EVS_TBL_User_Profile values (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps1 = con.prepareStatement(s);
				ps1.setString(MagicNumber.one, userid);
				ps1.setString(MagicNumber.two, profileBean.getFirstName());
				ps1.setString(MagicNumber.three, profileBean.getLastName());
				ps1.setDate(MagicNumber.four, profileBean.getDateOfBirth());
				ps1.setString(MagicNumber.five, profileBean.getGender());
				ps1.setString(MagicNumber.six, profileBean.getStreet());
				ps1.setString(MagicNumber.seven, profileBean.getLocation());
				ps1.setString(MagicNumber.eight, profileBean.getCity());
				ps1.setString(MagicNumber.nine, profileBean.getState());
				ps1.setString(MagicNumber.ten, profileBean.getPincode());
				ps1.setString(MagicNumber.eleven, profileBean.getMobileNo());
				ps1.setString(MagicNumber.twelve, profileBean.getEmailID());
				ps1.executeQuery();

				return userid;
			} else {
				return "invalid";
			}
		} catch (Exception e) {
			log.error(e);
			return "fail";
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
	 * @see com.wipro.evs.dao.ProfileDAO#findByID(java.lang.String)
	 * @param userId String
	 * @return ProfileBean
	 */

	public ProfileBean findByID(String userId) {
		ProfileBean profileBean=new ProfileBean(); 
		try
		{
		con=DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
		String s="select * from evs_tbl_user_profile where userID =?";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setString(MagicNumber.one, userId);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			
			profileBean.setUserID(userId);
			profileBean.setFirstName(rs.getString("firstname"));
			profileBean.setLastName(rs.getString("lastname"));
			profileBean.setDateOfBirth(rs.getDate("dateofBirth"));
			profileBean.setGender(rs.getString("gender"));
			profileBean.setStreet(rs.getString("street"));
			profileBean.setLocation(rs.getString("location"));
			profileBean.setCity(rs.getString("city"));
			profileBean.setState(rs.getString("state"));
			profileBean.setPincode(rs.getString("pincode"));
			profileBean.setMobileNo(rs.getString("mobileno"));
			profileBean.setEmailID(rs.getString("emailid"));
		}
		return profileBean;
		}
		catch(Exception e)
		{
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

}
