package com.coop.parish.core.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.io.FileUtils;

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

		Priest priest = null;
		if(priestBean == null || user == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		//Current user should be priest 
		if(user.getPriestId() == null) {
			throw new ParishException("Forbidden Request");
		}
	
		//convert to business object
		priest = priestBean.toBO();
		
		priest.setId(user.getPriestId()); //Id is not auto generated for Priest, It is taken from User Entity
		priest.setActive(true); //touch priest
		
		if(fileBean != null) { //profile image exists
			priest.setImageName(new StringBuilder(user.getPriestId()).append(".").append(fileBean.getFileType()).toString());
		}
		priest.setChurchId(user.getChurchId());
		
		PriestAdditionalInfo addInfo = new PriestAdditionalInfo();
		addInfo.setInfo(priestBean.getAdditionalInfo());
		priest.setAdditionalInfo(addInfo);
		
		Audit audit = new Audit();
		audit.setCreatedBy(user.getId());
		audit.setCreatedOn(new Date());
		audit.setLastModifiedBy(user.getId());
		audit.setLastModifiedOn(new Date());
		priest.setAudit(audit);
		em.persist(priest); //persist priest
		
		if(fileBean != null) { //ie profile image exists
			//save the profile image
			this.uploadPriestAvathar(user, fileBean);
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
	
	/**
	 * This method updates the priest profile (general info + additional Info), other than profile image
	 * @param priestBean
	 * @param user
	 * @return priestBean
	 * @throws Exception
	 */
	public PriestBean updatePriest(PriestBean priestBean, UserBean user) throws Exception {
		this.UpdatePriestDetails(priestBean, user);
		this.updatePriestAddInfo(priestBean, user);
		return priestBean;
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
	 * @param temp Temporary file 
	 * @param fileName 
	 * @return image name
	 * @throws IOException
	 */
	private String uploadPriestAvathar(UserBean user, FileBean fileBean) throws IOException {
		//check for necessary inputs
		if(fileBean == null || user == null || user.getPriestId() == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		StringBuilder builder = new StringBuilder(Constants.PRIEST_FOLDER);
		builder.append(File.separatorChar).append(user.getPriestId()).append(".").append(fileBean.getFileType());
		
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
	 * @param priestId
	 * @return boolean value representing if the priest profile is available or not
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
	
	/**
	 * This method uploads the priest profile image and changes the corresponding entry in db
	 * @Param priestId the priest profile to which the image belongs to
	 * @param fileBean new profile image
	 * @param user current session user
	 * @return void
	 */
	public void updatePriestAvathar(Integer priestId, FileBean fileBean,
			UserBean user) throws ParishException, IOException {
		if(priestId == null || fileBean == null || user == null) {//check for null params
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		if(!priestId.equals(user.getPriestId())) {//check if the user's priest id and priest id is same
			throw new ParishException("Forbidden Request");
		}
		
		//upload the file
		String imageName = this.uploadPriestAvathar(user, fileBean);
		
		//update the priest image name
		Query q = em.createQuery("update Priest p set p.imageName = :imageName where p.id = :priestId and p.isActive = :isActive");
		q.setParameter("imageName", imageName);
		q.setParameter("priestId", priestId);
		q.setParameter("isactive", true);
		
		int res = q.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
	}
	
	/**
	 * This method updates general priest profile information other than priest info
	 * @param priestBean 
	 * @param user current session user
	 * @return updated info
	 * @throws ParishException if the Entity doesn't exists
	 */
	public PriestBean UpdatePriestDetails(PriestBean priestBean, UserBean user)
			throws ParishException {
		//check for null params
				if(priestBean == null || user == null || priestBean.getId() == null) {
					throw new ParishException(Constants.PARAM_NULL_MSG);
				}
				
				if(priestBean.getId() <= 0 || user.getPriestId() == null) {
					throw new ParishException("Forbidden Request");
				}
				
				//TODO : direct queries are Typo Error Prone and difficult to maintain, But fast and decrease the number of queries executed 
				StringBuilder builder = new StringBuilder("update Priest p set p.name = :name, p.dob = :dob, p.birthPlace = :birthPlace, ");
				builder.append("p.education = :education, p.specilization = :specilization, p.educatedUniversity = :educatedUniversity, ");
				builder.append("p.doorNo = :doorNo, p.street = :street, p.village = :village, p.taluk = :taluk, p.district  = :district, p.state = :state, p.country = :country, p.pincode = :pincode, ");
				builder.append("p.telephoneNo = :telephoneNo, p.mobileNo = :mobileNo, p.emailId = :emailId, p.diocese = :diocese, p.additionalPosition = :additionalPosition, ");
				builder.append("p.audit.lastModifiedBy = :lastModifiedBy, p.audit.lastModifiedOn = :lastModifiedOn ");
				builder.append("where p.id = :priestId and p.isActive = :isActive");
				
				Query q = em.createQuery(builder.toString());
				q.setParameter("name", priestBean.getName());	
				q.setParameter("dob", priestBean.getDob());
				q.setParameter("birthPlace", priestBean.getBirthPlace());
				q.setParameter("education", priestBean.getEducation());
				q.setParameter("specilization", priestBean.getSpecialization());
				q.setParameter("educatedUniversity", priestBean.getEducatedUniversity());
				
				q.setParameter("doorNo", priestBean.getDoorNo());
				q.setParameter("street", priestBean.getStreet());
				q.setParameter("village", priestBean.getVillage());
				q.setParameter("taluk", priestBean.getTaluk());
				q.setParameter("district", priestBean.getDistrict());
				q.setParameter("state", priestBean.getState());
				q.setParameter("country", priestBean.getCountry());
				q.setParameter("pincode", priestBean.getPincode());
				
				q.setParameter("telephoneNo", priestBean.getTelephoneNo());
				q.setParameter("mobileNo", priestBean.getMobileNo());
				q.setParameter("emailId", priestBean.getEmailId());
				q.setParameter("diocese", priestBean.getDiocese());
				q.setParameter("additionalPosition", priestBean.getAdditionalPosition());
				
				q.setParameter("lastModifiedOn", new Date());
				q.setParameter("lastModifiedBy", user.getId());
				q.setParameter("priestId", priestBean.getId());
				q.setParameter("isActive", true);
				
				int res = q.executeUpdate();
				if(res <= 0) {
					throw new ParishException(Constants.NO_SUCH_OBJECT);
				}
				return priestBean;
	}
	
	/**
	 * This method updates the priest Additional Info
	 * @param priestBean
	 * @param user current session user info
	 * @return priest Bean 
	 * @throws ParishException if the Entity doesn't exists
	 */
	public PriestBean updatePriestAddInfo(PriestBean priestBean, UserBean user)
			throws ParishException {
		if(priestBean == null || user == null || priestBean.getId() == null) {
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		if(priestBean.getId() <= 0 || user.getPriestId() == null || !this.isPriestSet(priestBean.getId())) {
			throw new ParishException("Forbidden Request");
		}
	
		StringBuilder builder = new StringBuilder("update PriestAdditionalInfo pi set pi.info = :info where pi.priestId = :priestId");
		Query query = em.createQuery(builder.toString());
		query.setParameter("info", priestBean.getAdditionalInfo());
		query.setParameter("churchId", priestBean.getId());
		
		int res = query.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return priestBean;
	}

}
