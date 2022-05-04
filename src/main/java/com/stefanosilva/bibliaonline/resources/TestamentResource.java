package com.stefanosilva.bibliaonline.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.domain.Testament;
import com.stefanosilva.bibliaonline.dto.BookDTO;
import com.stefanosilva.bibliaonline.dto.TestamentDTO;
import com.stefanosilva.bibliaonline.services.BookService;
import com.stefanosilva.bibliaonline.services.TestamentService;

@RestController
@RequestMapping(value = "/v1/testament")
public class TestamentResource {

	@Autowired
	public TestamentService service;

	@Autowired
	public BookService serviceBook;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<TestamentDTO>> findAll(Pageable page) {
		Page<Testament> list = service.findAll(page);

		Page<TestamentDTO> listDto = list.map(t -> fromObj(t));
		
		listDto.forEach(t -> t.setBooks(findBooks(t.getId())));
		
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TestamentDTO> find(@PathVariable Integer id) {
		Testament obj = service.findById(id);
		if (obj == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		TestamentDTO dto = fromObj(obj);

		dto.setBooks(findBooks(id));
		
		return ResponseEntity.ok().body(dto);
	}

	private List<BookDTO> findBooks(Integer id) {
		// adicionar books]
		List<Book> books = serviceBook.findByTestament(id);

		List<BookDTO> booksDto = books.stream().map(b -> fromObjBook(b)).collect(Collectors.toList());
		return booksDto;

	}

	public TestamentDTO fromObj(Testament obj){
		return modelMapper.map(obj, TestamentDTO.class);
	}
	public BookDTO fromObjBook(Book obj){
		return modelMapper.map(obj, BookDTO.class);
	}
}
