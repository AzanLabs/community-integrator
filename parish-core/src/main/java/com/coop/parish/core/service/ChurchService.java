package com.coop.parish.core.service;

import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.beans.EChurchBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;


public interface ChurchService extends BaseService{
	
	public ChurchBean getChurchById(int id) throws Exception;
	
	public ChurchBean updateChurch(ChurchBean churchBean, UserBean userBean) throws Exception;
	
	public int deleteChurch(int id) throws Exception;
	
	public EChurchBean getEntireChurch(int id) throws Exception;
	
	/**
	 * This Method Creates a new Church Instance
	 * @param churchBean - bean which contains all the church information.
	 * @param user - bean which has the current user information
	 * @return - the saved church bean
	 * @throws Exception  If improper data is send to persist.
	 */	
	public ChurchBean saveChurchFirstSteps(ChurchBean churchBean, 
			UserBean user) throws ParishException;
	/**
	 * This method checks if the church profile is completed or not
	 * @param churchId 
	 * @return boolean status TRUE / FALSE
	 */
	public boolean isChurchSet(Integer churchId);
	
	/**
	 * Update the church Details excluding church additional info
	 * @param churchBean 
	 * @param user current session user
	 * @return Updated values
	 * @throws ParishException if the Entity doesn't exists
	 */
	public ChurchBean updateChurchDetails(ChurchBean churchBean, UserBean user) throws ParishException;
	
	/**
	 * update the church additional info
	 * @param churchBean
	 * @param user current session user info
	 * @return Updated value
	 * @throws ParishException if the entity to update doesn't exists
	 */
	public ChurchBean updateChurchInfo(ChurchBean churchBean, UserBean user) throws ParishException;
	
}
