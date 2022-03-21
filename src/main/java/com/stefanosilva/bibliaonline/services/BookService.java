package com.stefanosilva.bibliaonline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.dto.BookDTO;
import com.stefanosilva.bibliaonline.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repo;
	
	public Page<BookDTO> findAll(Pageable page ){
		
		Page<Book> list = repo.findAll(page);		
		Page<BookDTO> listDto = list.map(t -> new BookDTO(t));
		return listDto;
	}
	
	public BookDTO findById(Integer id) {
		Optional <Book> obj = repo.findById(id);
		
		if (obj != null) {
			BookDTO dto = new BookDTO(obj.get());
			return dto;
		}
		return null;
	}
	
	public BookDTO update(BookDTO dto, Integer id) {
		dto.setId(id);
		
		Book obj = repo.findById(id).get();
		obj = updateObj(obj, dto);
		obj = repo.save(obj);		
		
		return new BookDTO(obj);
	}
	
	public BookDTO insert(BookDTO dto) {
		dto.setId(null);
		Book obj = new Book(dto.getId(), dto.getTestament(), dto.getName(), dto.getAbbrev());
		obj = repo.save(obj);		
		
		return new BookDTO(obj);
	}
	
	public Book updateObj(Book obj,BookDTO dto) {
		obj.setName(dto.getName());
		return obj;
	}
	
}
