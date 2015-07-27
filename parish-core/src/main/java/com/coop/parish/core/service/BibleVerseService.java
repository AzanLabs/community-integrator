package com.coop.parish.core.service;

import java.util.List;

import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.beans.VerseBean;
import com.coop.parish.core.exceptions.ParishException;

public interface BibleVerseService extends BaseService {
	
	/**
	 * saves bible verses
	 * @param verses to save - List<VerseBean>
	 * @param user current session user info
	 * @return list of saved bible verses 
	 * @throws ParishException if the maximum capacity is reached
	 */
	public List<VerseBean> saveBibleVerses(List<VerseBean> verses, UserBean user) throws ParishException;
	
	/**
	 * updates  single bible verse
	 * @param verse - verse bean to update, returns NullPointerException if null
	 * @param user current session user info
	 * @return updated data
	 * @throws ParishException if the corresponding entity is not present
	 */
	public VerseBean upateBibleVerse(VerseBean verse, UserBean user) throws ParishException;
	
	/**
	 * disables a single verse
	 * @param verseId the entity id to disable
	 * @throws ParishException if the corresponding entity is not present
	 */
	public void disableBibleVerse(Integer verseId) throws ParishException;
	
	/**
	 * Soft Delete a Collection of verse
	 * @param ids List of verse Ids
	 * @throws ParishException if any of the corresponding entity is not found
	 */
	public void disableBibleVerses(List<Integer> ids) throws ParishException;
	
	/**
	 * This method returns the collection of (Default + custom) Bible Verses for a particular church
	 * @param churchId 
	 * @return list of verses
	 */
	public List<VerseBean> getVerseByChurch(Integer churchId);
}
