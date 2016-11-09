/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ApplicationDAO.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :11-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 11, 2014
 */
public interface ApplicationDAO {

	  /**
	 * @param applicationBean ApplicationBean
	 * @return String
	 */
	String createApplication(ApplicationBean applicationBean);
	 /**
	 * @return ArrayList
	 */
	ArrayList<ApplicationBean> findAllPending();
	/**
	 * @param applicationBean ApplicationBean
	 * @return boolean
	 */
	boolean updateApplication(ApplicationBean applicationBean);
	/**
	 * @param applicationBean ApplicationBean
	 * @return boolean
	 */
	boolean updateApplicationEO(ApplicationBean applicationBean);
	/**
	 * @return ArrayList
	 */
	ArrayList<ApplicationBean> findAllPendingEO();
	/**
	 * @param applicationBean ApplicationBean
	 * @return boolean
	 */
	boolean updateApplicationReject(ApplicationBean applicationBean);
	
	/**
	 * @param userId String
	 * @return String
	 */
	String checkVoterId(String userId);
	
	     /**
	     * @param userId String
	     * @param constituency String
	     * @return String
	     */
	String findByID(String userId,String constituency);
	
	
	    /**
	     * @param s ArrayList
	     * @return int
	     */
	    int deleteApplication(ArrayList<String> s);
	 	/**
	 	 * @return ArrayList
	 	 */
	 	ArrayList<ApplicationBean> findAll();


}
