/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : Administrator.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :08-DEC-2014
 *
 * Modification History: NA
 */
package com.wipro.evs.service;

import java.util.ArrayList;
import java.util.Map;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 8, 2014
 */
public interface Administrator 
{
   /**
 * @param electionBean ElectionBean
 * @return String
 */
String addElection(ElectionBean electionBean);
   /**
 * @return ArrayList<ElectionBean>
 */
ArrayList<ElectionBean> viewAllUpcomingElections();
   /**
 * @return ArrayList<ElectionBean>
 */
ArrayList<ElectionBean> viewElections();
   /**
 * @param partyBean PartyBean
 * @return String
 */
String addParty(PartyBean partyBean);
   /**
 * @return ArrayList<PartyBean>
 */
ArrayList<PartyBean> viewAllParty();
   /**
 * @param candidateBean CandidateBean
 * @return String
 */
String addCandidate(CandidateBean candidateBean);
   /**
 * @param electionName String
 * @return ArrayList<CandidateBean>
 */
ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName);
   /**
 * @return ArrayList<ApplicationBean>
 */

ArrayList<ApplicationBean> viewAllAdminPendingApplications();
   /**
 * @param userId String
 * @return boolean
 */
boolean forwardVoterIDRequest(String userId);
   /**
 * @param partyId String
 * @return ArrayList<CandidateBean>
 */
ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId);
   /**
 * @param electionId String
 * @return Map
 */
@SuppressWarnings("rawtypes")
Map approveElectionResults(String electionId);

/**
 * @param electionId String 
 * @return election bean
 */
ElectionBean viewElectionById(String electionId);
   
}
