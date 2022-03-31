package com.stefanosilva.bibliaonline.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Verses")
public class Verse implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="testament")
	private Testament testament;
		
	@ManyToOne
	@JoinColumn(name="book")
	private Book book;
	
	private String version;
	
	private Integer chapter;
	
	private Integer verse;
	
	@Column(length = 1000)
	private String text;

	public Verse(Integer id, Testament testament, Book book, String version, Integer chapter, Integer verse,
			String text) {
		super();
		this.id = id;
		this.testament = testament;
		this.book = book;
		this.version = version;
		this.chapter = chapter;
		this.verse = verse;
		this.text = text;
	}
	public Verse() { }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getChapter() {
		return chapter;
	}
	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}
	public Integer getVerse() {
		return verse;
	}
	public void setVerse(Integer verse) {
		this.verse = verse;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Verse [id=" + id + ", testament=" + testament + ", book=" + book + ", version="
				+ version + ", chapter=" + chapter + ", verse=" + verse + ", text=" + text + "]";
	}
	
}
