package com.stefanosilva.bibliaonline.dto;

import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.domain.Testament;
import com.stefanosilva.bibliaonline.domain.Verse;

public class VerseDTO {

private Integer id;
	
	private String name;

	private Testament testament;

	private Book book;
	
	private String version;
	
	private String chapter;
	
	private String verse;
	
	private String text;

	public VerseDTO(Integer id, String name, Testament testament, Book book, String version, String chapter, String verse,
			String text) {
		super();
		this.id = id;
		this.name = name;
		this.testament = testament;
		this.book = book;
		this.version = version;
		this.chapter = chapter;
		this.verse = verse;
		this.text = text;
	}
	public VerseDTO() { }
	
	public VerseDTO(Verse obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.testament = obj.getTestament();
		this.book = obj.getBook();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Testament getTestament() {
		return testament;
	}
	public void setTestament(Testament testament) {
		this.testament = testament;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
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
