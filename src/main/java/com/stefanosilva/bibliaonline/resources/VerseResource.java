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

import com.stefanosilva.bibliaonline.domain.Verse;
import com.stefanosilva.bibliaonline.dto.VerseDTO;
import com.stefanosilva.bibliaonline.services.VerseService;

@RestController
@RequestMapping(value="/v1/verses")
public class VerseResource {

	@Autowired
    public VerseService service;

	@Autowired
	ModelMapper modelMapper;


	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<VerseDTO>> findAll(Pageable page){
		Page<Verse> list = service.findAll(page);		
		
		Page<VerseDTO> listDto = list.map(t -> fromObj(t));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VerseDTO> find(@PathVariable Integer id) {
		Verse obj = service.findById(id);		
		if(obj == null) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		VerseDTO dto = fromObj(obj);
		return ResponseEntity.ok().body(dto);
	}	
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<List<VerseDTO>> search(
			@RequestParam(value="testamentId", defaultValue="1") Integer testamentId, 
			@RequestParam(value="bookId", defaultValue="0") Integer bookId, 
			@RequestParam(value="chapter", defaultValue="0") Integer chapter
			) {		
		List<Verse> list = service.search(testamentId, bookId, chapter);	
		List<VerseDTO> listDto = list.stream().map(t -> fromObj(t)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	public VerseDTO fromObj(Verse obj){
		return modelMapper.map(obj, VerseDTO.class);
	}
}
