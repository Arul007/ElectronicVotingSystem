/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : DBUtilImpl.java
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

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 4, 2014
 */
public class DBUtil {
	private static Logger log = Logger.getLogger(DBUtil.class);

	/**
	 * @see com.wipro.evs.util.DBUtil#getDBConnection(java.lang.String)
	 * @param driverType
	 *            for Connection
	 * @return Connection
	 * @throws IOException
	 *             java.io.IOException
	 * @throws SQLException
	 *             java.sql.SQLException
	 */
	
	public static Connection getDBConnection(String driverType) throws IOException,
			SQLException {
		try {
			log.info("Trying to create connection.....");
			Class.forName(driverType);
		} catch (ClassNotFoundException e) {
			log.warn("Class not found exception occured...");
			log.error(e);
		}
		Properties p = new Properties();
		p.load(DBUtil.class.getClassLoader().getResourceAsStream(
				"jdbc.properties"));
		return DriverManager.getConnection(p.getProperty("url"),
				p.getProperty("user"), p.getProperty("password"));

	}

}
