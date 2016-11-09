/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ResultBean.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :03-DEC-2014
 * 
 * Modification History:NA
 */
package com.wipro.evs.bean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 3, 2014
 */
public class ResultBean {
	
	private int serialNo;
	private String electionID;
	private String candidateID;
	private int voteCount;
	/**
	 * @return serialNo
	 */
	public int getSerialNo() {
		return serialNo;
	}
	/**
	 * @param serialNo type int
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * @return electionID
	 */
	public String getElectionID() {
		return electionID;
	}
	/**
	 * @param electionID type String
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	/**
	 * @return candidateID
	 */
	public String getCandidateID() {
		return candidateID;
	}
	/**
	 * @param candidateID type String
	 */
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	/**
	 * @return voteCount
	 */
	public int getVoteCount() {
		return voteCount;
	}
	/**
	 * @param voteCount type int
	 */
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
}
