package com.coop.parish.core.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.beans.VerseBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.BibleVerseService;

public class TestBibleVerses {
	
	BibleVerseService service = null;
	UserBean user = null;
	List<VerseBean> verses = null;
	EntityManager em = null;
	
	@BeforeClass
	public void setUp(){
		verses = new ArrayList<VerseBean>(20);
		service = ServiceLocator.instance().getBibleVerseService();
		int i = 0;
		while(++i <= 20) {
			VerseBean verse = new VerseBean();
			verse.setVerse("12");
			verse.setChapter("jacob");
			verse.setWords("be good");
			verses.add(verse);
		}
		
		user = new UserBean();
		user.setId(1001);
		user.setChurchId(2001);
	}
	
	@Test(enabled=false)
	public void testSaveVerses() throws ParishException {
		verses = service.saveBibleVerses(verses, user);
		System.out.println("verse id "+verses.get(0).getId());
		Assert.assertNotNull(verses.get(0).getId(), "should have a id");
	}
	
	@Test(enabled=false)
	public void testUpdateVerse() throws ParishException{
		VerseBean v = verses.get(0);
		v.setId(40);
		v.setChapter("update");
		v = service.upateBibleVerse(v, user);
	}
	
	@Test(enabled=false)
	public void testDisableVerses() throws ParishException {
		List<Integer> ids = new ArrayList<Integer>(20);
		int i = 0;
		while(++i <= 20){
			ids.add(i+20);
		}

		service.disableBibleVerses(ids);
	}
	
	@Test(enabled=true)
	public void testGetVerseByChurch() {
		List<VerseBean> v =service.getVerseByChurch(2001);
		System.out.println(v);
	}
}
