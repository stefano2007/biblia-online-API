package com.stefanosilva.bibliaonline.dto;

import com.stefanosilva.bibliaonline.domain.Verse;

public class VerseDTO {

private Integer id;
	
	private Integer testamentId;

	private Integer bookId;
	
	private String version;
	
	private String chapter;
	
	private String verse;
	
	private String text;

	public VerseDTO(Integer id, Integer testamentId, Integer bookId, String version, String chapter, String verse,
			String text) {
		super();
		this.id = id;
		this.testamentId = testamentId;
		this.bookId = bookId;
		this.version = version;
		this.chapter = chapter;
		this.verse = verse;
		this.text = text;
	}
	public VerseDTO() { }
	
	public VerseDTO(Verse obj) {
		super();
		this.id = obj.getId();
		this.testamentId = obj.getTestament().getId();
		this.bookId = obj.getBook().getId();
		this.version = obj.getVersion();
		this.chapter = obj.getChapter();
		this.verse = obj.getVerse();
		this.text = obj.getText();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}		

	public Integer getTestamentId() {
		return testamentId;
	}
	public void setTestamentId(Integer testamentId) {
		this.testamentId = testamentId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getVerse() {
		return verse;
	}
	public void setVerse(String verse) {
		this.verse = verse;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
