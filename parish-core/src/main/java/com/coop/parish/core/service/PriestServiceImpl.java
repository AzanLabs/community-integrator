package com.coop.parish.core.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.io.FileUtils;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.FileBean;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.Priest;
import com.coop.parish.data.modal.PriestAdditionalInfo;

public class PriestServiceImpl extends BaseServiceImpl implements PriestService{

	public PriestServiceImpl(EntityManager em) {
		super(em);
	}
	
	/**
	 * saves the priest profile with image gives back the saved data
	 * @param priestBean 
	 * @param user current user from session
	 * @param fileBean which represents the priest profile image
	 * @return data which represents priest
	 * @throws ParishException if the data is not valid
	 * @throws IOException 
	 */
	public PriestBean savePriest(PriestBean priestBean, UserBean user, FileBean fileBean) 
			throws ParishException, IOException {
		UserService userService = null;
		Priest priest = null;
		if(priestBean == null || user == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		//since our logged in users are only priest, are allowed to create their info only once
		if(user.getPriestId() != null) {
			throw new ParishException("Profile Already Exists");
		}
	
		//convert to business object
		priest = priestBean.toBO();
		
		priest.setActive(true); //touch priest
		priest.setImageType(fileBean.getFileType());
		priest.setChurch(new Church(user.getChurchId()));
		
		PriestAdditionalInfo addInfo = new PriestAdditionalInfo();
		addInfo.setInfo(priestBean.getAdditionalInfo().getBytes(Charset.forName("UTF-8")));
		priest.setAdditionalInfo(addInfo);
		
		Audit audit = new Audit();
		audit.setCreatedBy(user.getId());
		audit.setCreatedOn(new Date());
		audit.setLastModifiedBy(user.getId());
		audit.setLastModifiedOn(new Date());
		priest.setAudit(audit);
		em.persist(priest); //persist priest
		
		if(fileBean != null){
			//save the profile image and update the profile
			this.uploadPriestAvathar(user, priest.getId(), fileBean);
		}
		return new PriestBean(priest);		
	}

	public PriestBean getPriestById(int id) throws Exception {
		Priest priest = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		String str = "Select p from Priest as p where p.id=:id and p.isActive=:isActive";
		Query query = em.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("isActive", true);
		try{
			priest =  (Priest)query.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return new PriestBean(priest);
	}

	public PriestBean updatePriest(PriestBean priestBean, UserBean user) throws Exception {
		Priest priest = null;
		int id = 0;
		if(priestBean == null || user == null){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		id = priestBean.getId();
		if(id <= 0){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		Priest fromDB = em.find(Priest.class, id);
		if(fromDB != null){
			priest = priestBean.toBO();
			
			Audit audit = new Audit();
			audit.setCreatedBy(fromDB.getAudit().getCreatedBy());
			audit.setCreatedOn(fromDB.getAudit().getCreatedOn());
			audit.setLastModifiedBy(user.getId());
			audit.setLastModifiedOn(new Date());
			
			priest.setAudit(audit);
			priest.setActive(true);
			
			fromDB.getAdditionalInfo().setInfo(priest.getAdditionalInfo().getInfo());
			priest.setAdditionalInfo(fromDB.getAdditionalInfo());
			priest.setChurch(new Church(user.getChurchId()));
			em.merge(priest);
		}
		return new PriestBean(priest);
	}

	public int deletePriest(int id) throws Exception {
		Priest priest = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		priest = em.find(Priest.class, id);
		if(priest == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		priest.setActive(false);
		em.merge(priest);
		return priest.getId();
	}
	
	private boolean isInDB(int id) throws ParishException{
		Query q = em.createQuery("select id from Priest p where p.id=:id");
		q.setParameter("id", id);
		try{
			q.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return true;
	
	}

	public List<PriestBean> getAllPriest(int churchId) throws ParishException {
		List<Priest> priests = null;
		List<PriestBean> priestBeans = new ArrayList<PriestBean>();
		if(churchId <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		Query q = em.createQuery("select p from Priest p where p.church.id = :churchId and p.isActive = :isActive");
		q.setParameter("churchId", churchId);
		q.setParameter("isActive", true);
		priests = q.getResultList();
		//convert to priest bean
		if(priests != null){
			for(Priest p : priests){
				priestBeans.add(new PriestBean(p));
			}
		}
		return priestBeans;
	}
	
	/**
	 * This method saves the priest and return the filename of the image
	 * @param user current session user data
	 * @param priestId 
	 * @param temp Temporary file 
	 * @param fileName 
	 * @return image name
	 * @throws IOException
	 */
	private String uploadPriestAvathar(UserBean user, Integer priestId, FileBean fileBean) throws IOException {
		//check for necessary inputs
		if(fileBean == null || user == null || priestId == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		StringBuilder builder = new StringBuilder(FileUtils.getUserDirectoryPath()).append(File.separatorChar).append("parish");
		builder.append(File.separatorChar).append("priest").append(File.separatorChar);
		builder.append(priestId).append(".").append(fileBean.getFileType());
		
		System.out.println("path "+builder.toString());
		//create an empty file in the copy location
		File file = new File(builder.toString());
		//stream the temp file to the copy location
		FileUtils.copyFile(fileBean.getFile(), file);
		//return the file name
		return file.getName();
	}

	/**
	 * This method checks if the given priest profile is completed or not
	 * param priestId
	 * return boolean value representing if the priest profile is available or not
	 */
	public boolean isPriestSet(Integer priestId) {
		boolean isSet = false;
		if(priestId == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		Query query = em.createQuery("select id from Priest p where p.id = :id and p.isActive = :isActive");
		query.setParameter("id", priestId);
		query.setParameter("isActive", true);
		try {
			query.getSingleResult();
		} catch(NoResultException e) {
			return isSet;
		}
		isSet = true;
		return isSet;
	}

}
