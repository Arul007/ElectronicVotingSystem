/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ProfileBean.java
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

import java.sql.Date;

/**
 * @author training
 * @version 1.0
 * 
 */
public class ProfileBean {

	private String userID;
	private String firstName;
	private String lastName;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailID;
	private String password;
	private Date dateOfBirth;

	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID of user
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return firstName of type String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName of type String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName of type String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender of type String
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street of type String
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location of type String
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city of type String
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state of type String
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode of type String
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo of type String
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID of type String
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password of type String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth of type String
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
