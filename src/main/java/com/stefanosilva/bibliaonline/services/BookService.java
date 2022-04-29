package com.stefanosilva.bibliaonline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.domain.Testament;
import com.stefanosilva.bibliaonline.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repo;
	
	@Autowired
	TestamentService serviceTestament;
		
	public Page<Book> findAll(Pageable page ){
		Page<Book> list = repo.findAll(page);		
		return list;
	}
	
	public Book findById(Integer id) {
		Optional <Book> obj = repo.findById(id);
		
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	/*
	public Book update(BookDTO dto, Integer id) {
		dto.setId(id);
		
		Book obj = repo.findById(id).get();
		obj = updateObj(obj, dto);
		obj = repo.save(obj);		
		
		return obj;
	}
	
	public Book insert(BookDTO dto) {
		dto.setId(null);
		Book obj = new Book(dto.getId(), dto.getTestament(), dto.getName(), dto.getAbbrev());
		obj = repo.save(obj);		
		
		return obj;
	}
	public Book updateObj(Book obj,BookDTO dto) {
		obj.setName(dto.getName());
		return obj;
	}
   */
    public List<Book> findByTestament(Integer testamentID){
    	Testament testament = serviceTestament.findById(testamentID);
    	return repo.findByTestament(testament);	
    }
	
}
