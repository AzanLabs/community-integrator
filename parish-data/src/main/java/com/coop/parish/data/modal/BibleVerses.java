package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bible_verses")
public class BibleVerses {

	@Id
	@GeneratedValue
	@Column(name="verse_id")
	private Integer id;
	
	@Column(name="verse", nullable=false)
	private String verse;
	
	@Column(name="chapter", nullable=false)
	private String chapter;
	
	@Lob
	@Column(name="words", columnDefinition="TEXT", nullable=false)
	private String words;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="church_id", insertable=false, updatable=false)
	private Integer churchId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id")
	private Church church;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Embedded
	private Audit audit;
	
	public BibleVerses(){
		
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

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
		if(church.getBibleWords() != null) {
			church.getBibleWords().add(this);
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}
	
}
