package com.stefanosilva.bibliaonline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stefanosilva.bibliaonline.domain.Testament;
import com.stefanosilva.bibliaonline.repositories.TestamentRepository;

@Service
public class TestamentService {

	@Autowired
	TestamentRepository repo;
	
	public Page<Testament> findAll(Pageable page ){		
		Page<Testament> list = repo.findAll(page);	
		return list;
	}
	
	public Testament findById(Integer id) {
		Optional<Testament> obj = repo.findById(id);
		
		if (obj != null) {			
			return obj.get();
		}
		return null;
	}
	/*
	public Testament update(TestamentDTO dto, Integer id) {
		dto.setId(id);
		
		Testament obj = repo.findById(id).get();
		obj = updateObj(obj, dto);
		obj = repo.save(obj);		
		
		return obj;
	}
	
	public Testament insert(TestamentDTO dto) {
		dto.setId(null);
		Testament obj = new Testament(dto.getId(), dto.getName());
		obj = repo.save(obj);		
		
		return obj;
	}
	
	public Testament updateObj(Testament obj,TestamentDTO dto) {
		obj.setName(dto.getName());
		return obj;
	}
   */	
}
