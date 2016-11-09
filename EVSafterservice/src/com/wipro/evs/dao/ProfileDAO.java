/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :XYZ
 *
 * File Name       : ProfileDAO.java
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

import com.wipro.evs.bean.ProfileBean;

/**
 *
 * @author Arul
 * @author Liji
 * @version 1.0 
 * @since 1.0
 * Date : Dec 8, 2014
 */
public interface ProfileDAO 
{
     /**
     * @param profileBean ProfileBean
     * @return String 
     */
    String createProfile(ProfileBean profileBean);
    /**
     * @param userId String
     * @return ProfileBean
     */
    ProfileBean findByID(String userId);
     //int deleteProfile(ArrayList<String>);
     //boolean updateProfile(ProfileBean profileBean);
     //ArrayList<ProfileBean> findAll();
}
