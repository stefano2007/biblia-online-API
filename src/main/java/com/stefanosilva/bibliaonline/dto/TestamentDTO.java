package com.stefanosilva.bibliaonline.dto;

import java.util.ArrayList;
import java.util.List;

import com.stefanosilva.bibliaonline.domain.Testament;

public class TestamentDTO {

	private Integer id;

	private String name;

	private List<BookDTO> books = new ArrayList<BookDTO>();

	public TestamentDTO(Integer id, String name, List<BookDTO> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public TestamentDTO() {
	}

	public TestamentDTO(Testament obj) {
		this.id = obj.getId();
		this.name = obj.getName();
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

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	
	
}
