package com.coop.parish.core.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.Priest;
import com.coop.parish.data.modal.User;

public class UserServiceImpl extends BaseServiceImpl implements UserService{

	public UserServiceImpl(EntityManager em) {
		super(em);
	}
}
