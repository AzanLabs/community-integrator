package com.coop.parish.core.service;

import javax.persistence.EntityManager;

import com.coop.parish.core.beans.ChurchBean;

public class ChurchServiceImpl extends BaseServiceImpl implements ChurchService{

	public ChurchServiceImpl(EntityManager em) {
		super(em);
	}

	public ChurchBean saveChurch(ChurchBean church) {
		System.out.println("saving church");
		return church;
	}
}
