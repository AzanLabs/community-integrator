package com.coop.parish.core.service;

import java.util.Map;

import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.beans.EChurchBean;


public interface ChurchService extends BaseService{
	
	public ChurchBean getChurchById(int id) throws Exception;
	
	public ChurchBean updateChurch(ChurchBean churchBean) throws Exception;
	
	public int deleteChurch(int id) throws Exception;
	
	public EChurchBean getEntireChurch(int id) throws Exception;

	public ChurchBean saveChurch(ChurchBean churchBean,
			Map<String, Object> session) throws Exception;
}
