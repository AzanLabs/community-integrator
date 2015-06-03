package com.coop.parish.core.service;

import com.coop.parish.core.beans.ChurchBean;


public interface ChurchService extends BaseService{
	
	public ChurchBean saveChurch(ChurchBean church) throws Exception;
	
	public ChurchBean getChurchById(int id) throws Exception;
	
	public ChurchBean updateChurch(ChurchBean churchBean) throws Exception;
	
	public int deleteChurch(int id) throws Exception;
}
