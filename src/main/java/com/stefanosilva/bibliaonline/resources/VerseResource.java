package com.stefanosilva.bibliaonline.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stefanosilva.bibliaonline.dto.VerseDTO;
import com.stefanosilva.bibliaonline.services.VerseService;

@RestController
@RequestMapping(value="/v1/verses")
public class VerseResource {

	@Autowired
    public VerseService service;
   
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<VerseDTO>> findAll(Pageable page){
		Page<VerseDTO> list = service.findAll(page);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VerseDTO> find(@PathVariable Integer id) {
		VerseDTO dto = service.findById(id);
		
		if(dto == null) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.ok().body(dto);
	}	
	
}
