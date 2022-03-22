package com.stefanosilva.bibliaonline.dto;

import com.stefanosilva.bibliaonline.domain.Book;

public class BookDTO {
private Integer id;
	
    
	private Integer testamentId;
	
	private String name;

	private String abbrev;

	public BookDTO(Integer id, Integer testamentId, String name, String abbrev) {
		this.id = id;
		this.testamentId = testamentId;
		this.name = name;
		this.abbrev = abbrev;
	}
	
	public BookDTO() {
	}

	public BookDTO(Book obj) {
		this.id = obj.getId();
		this.testamentId = obj.getTestament().getId();
		this.name = obj.getName();
		this.abbrev = obj.getAbbrev();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
}
