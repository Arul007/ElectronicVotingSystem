/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : DBUtilTest.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :17-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 17, 2014
 */
public class DBUtilTest {
	private static Logger log = Logger.getLogger(DBUtilTest.class);

	/**
	 * Test method for {@link com.wipro.evs.util.DBUtil#getDBConnection(java.lang.String)}.
	 */
	@Test
	public void testGetDBConnection() {
		try
		{
		Connection con=DBUtil.getDBConnection("oracle.jdbc.OracleDriver");
		assertNotNull(con);
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}

}
