package com.stefanosilva.bibliaonline.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Books")
@Data
@NoArgsConstructor
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="testament")
	private Testament testament;
	
	private String name;

	private String abbrev;

}
