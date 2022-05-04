package com.stefanosilva.bibliaonline.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.dto.BookDTO;
import com.stefanosilva.bibliaonline.dto.ListCharpterDTO;
import com.stefanosilva.bibliaonline.services.BookService;
import com.stefanosilva.bibliaonline.services.VerseService;

@RestController
@RequestMapping(value="/v1/books")
public class BookResource {

	@Autowired
    public BookService service;
	
	@Autowired
    public VerseService serviceVerse;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<BookDTO>> findAll(Pageable page){
		Page<Book> list = service.findAll(page);		
		
		Page<BookDTO> listDto = list.map(t -> fromObj(t));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<BookDTO> find(@PathVariable Integer id) {
		Book obj = service.findById(id);		
		if(obj == null) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		BookDTO dto = fromObj(obj);
		return ResponseEntity.ok().body(dto);
	}		
	
	@RequestMapping(value="/testament/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> findByTestament(@PathVariable Integer id) {
		List<Book> list  = service.findByTestament(id);		
		List<BookDTO> listDto = list.stream().map(t -> fromObj(t)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/charpters", method=RequestMethod.GET)
	public ResponseEntity<ListCharpterDTO> getDistinctChapter(
			@RequestParam(value="testamentId", defaultValue="1") Integer testamentId, 
			@RequestParam(value="bookId", defaultValue="0") Integer bookId
			) {		
		ListCharpterDTO dto = new ListCharpterDTO();
		
		BookDTO book = fromObj(service.findById(bookId));
		List<Integer> list = serviceVerse.getDistinctChapter(testamentId, bookId);
		
		dto.setBook(book);
		dto.setCharpters(list);
		return ResponseEntity.ok().body(dto);
	}

	public BookDTO fromObj(Book obj){
		return modelMapper.map(obj, BookDTO.class);
	}

}
