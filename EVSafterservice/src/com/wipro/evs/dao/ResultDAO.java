/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ResultDAO.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :12-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.ResultBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 12, 2014
 */
public interface ResultDAO {

	  /**
	 * @param resultBean ResultBean
	 * @return String
	 */
	String createResult(ResultBean resultBean);
	   /**
	 * @param resultBean ResultBean
	 * @return boolean
	 */
	boolean updateResult(ResultBean resultBean);
	 /**
	 * @param s ArrayList
	 * @return int
	 */
	//int deleteResult(ArrayList<String> s);
	  /**
	 * @param a String
	 * @return ResultBean
	 */
	//ResultBean findByID(String a);
	   /**
	 * @return ArrayList
	 */
	ArrayList<ResultBean> findAll();
}
