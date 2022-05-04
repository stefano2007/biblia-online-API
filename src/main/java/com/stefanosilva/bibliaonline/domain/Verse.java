package com.stefanosilva.bibliaonline.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
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

}
