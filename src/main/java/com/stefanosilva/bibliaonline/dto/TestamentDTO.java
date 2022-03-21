package com.stefanosilva.bibliaonline.dto;

import com.stefanosilva.bibliaonline.domain.Testament;

public class TestamentDTO {

	private Integer id;

	private String name;

	public TestamentDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public TestamentDTO() {}
	
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
}
