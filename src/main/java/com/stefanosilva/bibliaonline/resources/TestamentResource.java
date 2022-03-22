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

import com.stefanosilva.bibliaonline.domain.Testament;
import com.stefanosilva.bibliaonline.dto.TestamentDTO;
import com.stefanosilva.bibliaonline.services.TestamentService;

@RestController
@RequestMapping(value="/v1/testament")
public class TestamentResource {

	@Autowired
    public TestamentService service;
   
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<TestamentDTO>> findAll(Pageable page){
		Page<Testament> list = service.findAll(page);		
		
		Page<TestamentDTO> listDto = list.map(t -> new TestamentDTO(t));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TestamentDTO> find(@PathVariable Integer id) {
		Testament obj = service.findById(id);		
		if(obj == null) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		TestamentDTO dto = new TestamentDTO(obj);
		return ResponseEntity.ok().body(dto);
	}	

}
