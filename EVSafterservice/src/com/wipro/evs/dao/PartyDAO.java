/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : PartyDAO.java
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

import java.util.ArrayList;

import com.wipro.evs.bean.PartyBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 8, 2014
 */
public interface PartyDAO {
	
	 /**
	 * @param partyBean PartyBean
	 * @return String
	 */
	String createParty(PartyBean partyBean);
	
     /**
     * @param party ArrayList
     * @return int
     */
    int deleteParty(ArrayList<String> party);
   
     /**
     * @param partyID String
     * @return String
     */
    PartyBean findByID(String partyID);
     /**
     * @return ArrayList<PartyBean>
     */
    ArrayList<PartyBean> findAll();
    /**
     * @param partyBean PartyBean
     * @return boolean
     */
    boolean updateParty(PartyBean partyBean);

}
