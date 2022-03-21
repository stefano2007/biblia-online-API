package com.stefanosilva.bibliaonline.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Testament testament;
	
	private String name;

	private String abbrev;

	public Book(Integer id, Testament testament, String name, String abbrev) {
		this.id = id;
		this.testament = testament;
		this.name = name;
		this.abbrev = abbrev;
	}
	
	public Book() {
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", testament=" + testament + ", name=" + name + ", abbrev=" + abbrev + "]";
	}
	
}