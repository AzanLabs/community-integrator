package com.coop.parish.core.service;

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
	
	public PriestBean updatePriest(PriestBean priestBean, UserBean user) throws Exception;
	
	public int deletePriest(int id) throws Exception;
	
	public List<PriestBean> getAllPriest(int churchId) throws ParishException;
	
	public boolean isPriestSet(Integer priestId);
	
}
