package com.coop.parish.core.beans;

import com.coop.parish.data.modal.BibleVerses;

/**
 * Bible Verse Bean Class which represents the Priest Entity.
 * This Bean has methods to convert Bean to Entity Object and Entity Object to beans,
 * The Entity - Bean , Bean - Entity Conversion does not Consider all the fields involved, 
 * This Bean also has the Struts Validation Annotation, Only common Validations should be present here.
 * Action Specific Validations should be done in validate method.  
 */
public class VerseBean {
	
	private Integer id;
	private String verse;
	private String chapter;
	private String words;
	private String type;
	
	public VerseBean() {
		
	}
	
	/**
	 * Constructor which Populates Bean.
	 * Some fields present in the the Entity Objects might be omitted in the beans , ex : Audit fields
	 * @param bible verse entity
	 */
	public VerseBean(BibleVerses verse) {
		if(verse != null) {
			this.setId(verse.getId());
			this.setVerse(verse.getVerse());
			this.setChapter(verse.getChapter());
			this.setWords(verse.getWords());
			this.setType(verse.getType());
		}
	}
	
	/**
	 * Converts "this" bean to the relative Entity Object.
	 * The Returned Entity Object is not complete, fields which need not to be modified directly by user are omitted.
	 * @return entity which wraps the bean values 
	 */
	public BibleVerses toBO() {
		BibleVerses verse = new BibleVerses();
		
		verse.setId(this.getId());
		verse.setChapter(this.getChapter());
		verse.setVerse(this.getVerse());
		verse.setWords(this.getWords());
		return verse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVerse() {
		return verse;
	}

	public void setVerse(String verse) {
		this.verse = verse;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
