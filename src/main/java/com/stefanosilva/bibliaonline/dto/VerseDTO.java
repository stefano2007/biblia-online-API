package com.stefanosilva.bibliaonline.dto;

import com.stefanosilva.bibliaonline.domain.Verse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerseDTO {

private Integer id;
	
	private Integer testamentId;

	private Integer bookId;
	
	private String version;
	
	private Integer chapter;
	
	private Integer verse;
	
	private String text;

}
