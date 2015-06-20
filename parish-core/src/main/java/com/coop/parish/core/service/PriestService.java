package com.coop.parish.core.service;

import java.io.File;
import java.util.List;

import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;

public interface PriestService extends BaseService{
	
	public PriestBean savePriest(PriestBean priestBean, UserBean user, File file,String contentType) throws Exception;
	
	public PriestBean getPriestById(int id) throws Exception;
	
	public PriestBean updatePriest(PriestBean priestBean) throws Exception;
	
	public int deletePriest(int id) throws Exception;
	
	public List<PriestBean> getAllPriest(int churchId) throws ParishException;
	
}
