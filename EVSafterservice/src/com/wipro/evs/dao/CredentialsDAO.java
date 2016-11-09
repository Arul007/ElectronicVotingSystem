/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : CredentialDAO.java
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

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 8, 2014
 */
public interface CredentialsDAO {
	
	 /**
     * @param credentialsBean CredentialsBean
     * @return String 
     */
   // String createCredentials(CredentialsBean credentialsBean);
     /**
     * @param s  ArrayList
     * @return int
     */
   // int deleteCredentials(ArrayList<String> s);
     /**
     * @param credentialsBean CredentialsBean
     * @return boolean
     */
  //  boolean updateCredentials(CredentialsBean credentialsBean);
     /**
     * @param a String
     * @return CredentialsBean
     */
   // CredentialsBean findByID(String a);
     /**
     * @return ArrayList
     */
   // ArrayList<CredentialsBean> findAll();

}
