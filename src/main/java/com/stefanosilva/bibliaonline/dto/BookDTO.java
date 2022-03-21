package com.stefanosilva.bibliaonline.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.domain.Testament;

public class BookDTO {
private Integer id;
	
    @JsonIgnore
	private Testament testament;
	
	private String name;

	private String abbrev;

	public BookDTO(Integer id, Testament testament, String name, String abbrev) {
		this.id = id;
		this.testament = testament;
		this.name = name;
		this.abbrev = abbrev;
	}
	
	public BookDTO() {
	}

	public BookDTO(Book obj) {
		this.id = obj.getId();
		this.testament = obj.getTestament();
		this.name = obj.getName();
		this.abbrev = obj.getAbbrev();
	}
	
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
