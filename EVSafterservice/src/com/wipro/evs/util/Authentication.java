/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : Authentication.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :03-DEC-2014
 * 
 * Modification History:NA
 */
package com.wipro.evs.util;

import java.io.IOException;

import com.wipro.evs.bean.CredentialsBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 4, 2014
 */
public interface Authentication {
	/**
	 * @param user CredentialsBean
	 * @return boolean
	 */
	boolean authenticate(CredentialsBean user);

	/**
	 * @param userId String
	 * @return String
	 */
	String authorize(String userId);

	/**
	 * @param user CredentialsBean
	 * @param loginStatus int
	 * @return boolean
	 * @throws IOException 
	 */
	boolean changeLoginStatus(CredentialsBean user, int loginStatus) throws IOException;
	

}
