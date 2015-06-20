package com.coop.parish.core.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaUpdate;

import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.User;

public class UserServiceImpl extends BaseServiceImpl implements UserService{

	public UserServiceImpl(EntityManager em) {
		super(em);
	}

	public UserBean getUserById(Integer id) throws Exception {
		if(id == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		User user = em.find(User.class, id);
		return new UserBean(user);
	}

	public void updateChurchId(UserBean user) throws Exception {
		Query query = em.createQuery("update User u set u.churchId = :churchId where u.id = :id and u.isActive = :isActive");
		query.setParameter("churchId", user.getChurchId());
		query.setParameter("id", user.getId());
		query.setParameter("isActive", true);
		query.executeUpdate();
	}
}
