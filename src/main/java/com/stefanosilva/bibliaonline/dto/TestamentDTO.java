package com.stefanosilva.bibliaonline.dto;

import java.util.ArrayList;
import java.util.List;

import com.stefanosilva.bibliaonline.domain.Testament;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestamentDTO {

	private Integer id;

	private String name;

	private List<BookDTO> books = new ArrayList<BookDTO>();

}
