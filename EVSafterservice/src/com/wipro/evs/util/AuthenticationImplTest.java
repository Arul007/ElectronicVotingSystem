/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : AuthenticationImplTest.java
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wipro.evs.bean.CredentialsBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 17, 2014
 */
public class AuthenticationImplTest {

	/**
	 * Test method for {@link com.wipro.evs.util.AuthenticationImpl#authenticate(com.wipro.evs.bean.CredentialsBean)}.
	 */
	@Test
	public void testAuthenticate() {
		CredentialsBean user=new CredentialsBean();
		user.setUserID("admin");
		user.setPassword("0000");
		Authentication ad=new AuthenticationImpl();
		boolean b=ad.authenticate(user);
		assertTrue(b);
	}

	/**
	 * Test method for {@link com.wipro.evs.util.AuthenticationImpl#authorize(java.lang.String)}.
	 */
	@Test
	public void testAuthorize() {
		Authentication ad=new AuthenticationImpl();
		String s=ad.authorize("admin");
		assertEquals(s, "A");
	}

}
