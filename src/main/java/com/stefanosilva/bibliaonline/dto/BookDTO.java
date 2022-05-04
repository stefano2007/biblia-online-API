package com.stefanosilva.bibliaonline.dto;

import com.stefanosilva.bibliaonline.domain.Book;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BookDTO {
private Integer id;

	private Integer testamentId;
	
	private String name;

	private String abbrev;

}
