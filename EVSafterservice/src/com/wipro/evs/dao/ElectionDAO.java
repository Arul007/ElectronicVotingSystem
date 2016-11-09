/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ElectionDAO.java
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

import java.sql.Date;
import java.util.ArrayList;

import com.wipro.evs.bean.ElectionBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0
 * @since 1.0 Date : Dec 8, 2014
 */
public interface ElectionDAO {

	/**
	 * @param electionBean
	 *            ElectionBean
	 * @return String
	 */
	String createElection(ElectionBean electionBean);

	/**
	 * @param date
	 *            Date
	 * @return ArrayList<ElectionBean>
	 */
	ArrayList<ElectionBean> findBy(Date date);

	/**
	 * @return ArrayList<ElectionBean>
	 */
	ArrayList<ElectionBean> findAll();

	/**
	 * @param electionID String
	 * @return ElectionBean
	 */
	ElectionBean findByID(String electionID);
	/**
	 * @param electionBean ElectionBean
	 * @return boolean
	 */
	
	 boolean updateElection(ElectionBean electionBean);
	 /**
	 * @param election ArrayList<String>
	 * @return int
	 */
	int deleteElection(ArrayList<String> election);

}
