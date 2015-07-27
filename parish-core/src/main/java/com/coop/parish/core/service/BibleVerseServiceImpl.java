package com.coop.parish.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.beans.VerseBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.BibleVerses;
import com.coop.parish.data.modal.Church;

public class BibleVerseServiceImpl extends BaseServiceImpl implements BibleVerseService {

	
	public BibleVerseServiceImpl(EntityManager em) {
		super(em);
	}

	/**
	 * saves bible verses
	 * @param verses to save - List<VerseBean>
	 * @return list of saved bible verses 
	 * @throws ParishException 
	 */
	public List<VerseBean> saveBibleVerses(List<VerseBean> verses, UserBean user) throws ParishException {
		Integer maxAllowed = 20; //move this to system property
		int count = 0;
		if(verses == null || verses.isEmpty() || user == null) { //check for null and empty collection
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		count =  verses.size() + this.countOfVerseInDB(user.getChurchId());
		if(count > maxAllowed) { //check for max allowed size of verses
			throw new ParishException("Maximum Allowed size reached. maximum allowed size is {0}", new Integer[]{maxAllowed});
		}
		
		Audit audit = new Audit();
		audit.setCreatedBy(user.getId());
		audit.setCreatedOn(new Date());
		audit.setLastModifiedBy(user.getId());
		audit.setLastModifiedOn(new Date());
		
		Church church = new Church(user.getChurchId());
		List<BibleVerses> savedVerses = new ArrayList<BibleVerses>(verses.size());
		BibleVerses verse = null;
		for(VerseBean b : verses) {
			verse = b.toBO();
			verse.setChurch(church);
			verse.setActive(true);
			verse.setType("C");
			verse.setAudit(audit);
			em.persist(verse);
			savedVerses.add(verse);
		}
		verses.clear();
		for(BibleVerses v : savedVerses) {
			verses.add(new VerseBean(v));
		}
		return verses;
	}
	
	/**
	 * updates  single bible verse
	 * @param verse - verse bean to update, returns NullPointerException if null
	 * @return updated data
	 * @throws ParishException if the corresponding entity is not present
	 */
	public VerseBean upateBibleVerse(VerseBean verse, UserBean user) throws ParishException {
		if(verse == null || verse.getId() == null || verse.getId() <= 0 || user == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		StringBuilder builder = new StringBuilder("update BibleVerses bv set bv.verse = :verse , bv.chapter = :chapter , bv.words = :words, ");
		builder.append("bv.audit.lastModifiedOn = :lastModifiedOn, bv.audit.lastModifiedBy = :lastModifiedBy ");
		builder.append("where bv.id = :id and bv.isActive = :isActive");
		
		System.out.println("query "+builder.toString());
		Query query = em.createQuery(builder.toString());
		query.setParameter("id", verse.getId());
		query.setParameter("verse", verse.getVerse());
		query.setParameter("chapter", verse.getChapter());
		query.setParameter("words", verse.getWords());
		query.setParameter("lastModifiedOn", new Date());
		query.setParameter("lastModifiedBy", user.getId());
		query.setParameter("isActive", true);
		
		int res = query.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return verse;
	}
	
	/**
	 * disables a single verse
	 * @param verseId the entity id to disable
	 * @throws ParishException if the corresponding entity is not present
	 */
	public void disableBibleVerse(Integer verseId) throws ParishException {
		if(verseId == null || verseId <= 0) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		Query query = em.createQuery("update BibleVerses bv set bv.isActive = :isActive where bv.id = :id");
		query.setParameter("id", verseId);
		query.setParameter("isActive", false);
		
		int res = query.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
	}
	
	/**
	 * Soft Delete a Collection of verse
	 * @param ids array of verse Ids
	 * @throws ParishException if any of the corresponding entity is not found
	 */
	public void disableBibleVerses(List<Integer> ids) throws ParishException {
		if(ids == null || ids.isEmpty()) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		
		if(ids.size() > 20) {
			throw new ParishException("Forbidden Request");
		}
		
		Query query = em.createQuery("update BibleVerses bv set bv.isActive = :isActive where bv.id in :ids");
		query.setParameter("ids", ids);
		query.setParameter("isActive", false);

		int res = query.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
	}
	
	/**
	 * This method returns the collection of (Default + custom) Bible Verses for a particular church
	 * @param churchId 
	 * @return list of verses
	 */
	public List<VerseBean> getVerseByChurch(Integer churchId) {
		if(churchId == null || churchId <= 0) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		List<BibleVerses> verses = null;
		List<VerseBean> beans = new ArrayList<VerseBean>(40);
		
		Query query = em.createQuery("select bv from BibleVerses bv where bv.type = 'D' or (bv.churchId = :churchId and bv.isActive = :isActive)");
		query.setParameter("churchId", churchId);
		query.setParameter("isActive", true);
		
		verses = query.getResultList();
		for(BibleVerses v : verses) {
			beans.add(new VerseBean(v));
		}
		return beans;
	}
	
	private int countOfVerseInDB(Integer churchId) {
		Long count = 0L;
		if(churchId == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		Query query = em.createQuery("select count(v.id) from BibleVerses v where v.churchId = :churchId and v.isActive = :isActive");
		query.setParameter("churchId", churchId);
		query.setParameter("isActive", true);
		count = (Long) query.getSingleResult();
		return Integer.valueOf(count.toString());
	}

}
