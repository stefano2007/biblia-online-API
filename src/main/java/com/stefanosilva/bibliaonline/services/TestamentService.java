package com.stefanosilva.bibliaonline.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stefanosilva.bibliaonline.domain.Testament;
import com.stefanosilva.bibliaonline.dto.TestamentDTO;
import com.stefanosilva.bibliaonline.repositories.TestamentRepository;

@Service
public class TestamentService {

	@Autowired
	TestamentRepository repo;
	
	public Page<TestamentDTO> findAll(Pageable page ){
		
		Page<Testament> list = repo.findAll(page);		
		Page<TestamentDTO> listDto = list.map(t -> new TestamentDTO(t));
		return listDto;
	}
	
	public TestamentDTO findById(Integer id) {
		Optional <Testament> obj = repo.findById(id);
		
		if (obj != null) {
			TestamentDTO dto = new TestamentDTO(obj.get());
			return dto;
		}
		throw new   ObjectNotFoundException("Objeto nÃ£o encontrado! Id: " + id, null);
	}
	
	public TestamentDTO update(TestamentDTO dto, Integer id) {
		dto.setId(id);
		
		Testament obj = repo.findById(id).get();
		obj = updateObj(obj, dto);
		obj = repo.save(obj);		
		
		return new TestamentDTO(obj);
	}
	
	public TestamentDTO insert(TestamentDTO dto) {
		dto.setId(null);
		Testament obj = new Testament(dto.getId(), dto.getName());
		obj = repo.save(obj);		
		
		return new TestamentDTO(obj);
	}
	
	public Testament updateObj(Testament obj,TestamentDTO dto) {
		obj.setName(dto.getName());
		return obj;
	}
	
}
