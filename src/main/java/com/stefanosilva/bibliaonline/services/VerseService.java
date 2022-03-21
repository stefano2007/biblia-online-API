package com.stefanosilva.bibliaonline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stefanosilva.bibliaonline.domain.Verse;
import com.stefanosilva.bibliaonline.dto.VerseDTO;
import com.stefanosilva.bibliaonline.repositories.VerseRepository;

@Service
public class VerseService {

	@Autowired
	VerseRepository repo;
	
	public Page<VerseDTO> findAll(Pageable page ){
		
		Page<Verse> list = repo.findAll(page);		
		Page<VerseDTO> listDto = list.map(t -> new VerseDTO(t));
		return listDto;
	}
	
	public VerseDTO findById(Integer id) {
		Optional <Verse> obj = repo.findById(id);
		
		if (obj != null) {
			VerseDTO dto = new VerseDTO(obj.get());
			return dto;
		}
		return null;
	}
	
	public VerseDTO update(VerseDTO dto, Integer id) {
		dto.setId(id);
		
		Verse obj = repo.findById(id).get();
		obj = updateObj(obj, dto);
		obj = repo.save(obj);		
		
		return new VerseDTO(obj);
	}
	
	public VerseDTO insert(VerseDTO dto) {
		dto.setId(null);
		Verse obj = new Verse(dto.getId(), dto.getName(), dto.getTestament(), 
				dto.getBook(), dto.getVersion(), dto.getChapter(), dto.getVerse(), dto.getText());
		obj = repo.save(obj);		
		
		return new VerseDTO(obj);
	}
	
	public Verse updateObj(Verse obj,VerseDTO dto) {
		obj.setName(dto.getName());
		return obj;
	}
	
}
