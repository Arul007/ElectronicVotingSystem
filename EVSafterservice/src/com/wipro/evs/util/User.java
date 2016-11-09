/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : User.java
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

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 4, 2014
 */
public interface User 
{
   /**
 * @param credentialsBean CredentialsBean
 * @return String
 */
String login(CredentialsBean credentialsBean);
   /**
 * @param userId String
 * @return boolean
 */
boolean logout(String userId);
   /**
 * @param credentialsBean CredentialsBean
 * @param newPassword String
 * @return String
 */
String changePassword(CredentialsBean credentialsBean,String newPassword);

/**
 * @param profileBean ProfileBean
 * @return String
 */
String register(ProfileBean profileBean);
}