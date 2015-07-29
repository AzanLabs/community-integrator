package com.coop.parish.core.service;

import java.io.IOException;
import java.util.List;

import com.coop.parish.core.beans.FileBean;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;

public interface PriestService extends BaseService{
	
	/**
	 * saves the priest profile with image gives back the saved data
	 * @param priestBean 
	 * @param user current user from session
	 * @param file profile image
	 * @param contentType type of file
	 * @return data which represents priest
	 * @throws ParishException if the data is not valid
	 */
	public PriestBean savePriest(PriestBean priestBean, UserBean user, FileBean fileBean) throws Exception;
	
	public PriestBean getPriestById(int id) throws Exception;
	
	/**
	 * This method updates the priest profile (general info + additional Info), other than profile image
	 * @param priestBean
	 * @param user
	 * @return priestBean
	 * @throws Exception
	 */
	public PriestBean updatePriest(PriestBean priestBean, UserBean user) throws Exception;
	
	public int deletePriest(int id) throws Exception;
	
	public List<PriestBean> getAllPriest(int churchId) throws ParishException;
	
	public boolean isPriestSet(Integer priestId);

	/**
	 * This method uploads the priest profile image and changes the corresponding entry in db
	 * @Param priestId the priest profile to which the image belongs to
	 * @param fileBean new profile image
	 * @param user current session user
	 * @return void
	 */
	public void updatePriestAvathar(Integer priestId, FileBean fileBean, UserBean user) throws ParishException, IOException;
	
	/**
	 * This method updates general priest profile information other than priest info
	 * @param priestBean 
	 * @param user current session user
	 * @return updated info
	 * @throws ParishException if the Entity doesn't exists
	 */
	public PriestBean UpdatePriestDetails(PriestBean priestBean, UserBean user) throws ParishException;
	
	/**
	 * This method updates the priest Additional Info
	 * @param priestBean
	 * @param user current session user info
	 * @return priest Bean 
	 * @throws ParishException if the Entity doesn't exists
	 */
	public PriestBean updatePriestAddInfo(PriestBean priestBean, UserBean user) throws ParishException;
	
}
