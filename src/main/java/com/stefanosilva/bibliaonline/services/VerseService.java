package com.stefanosilva.bibliaonline.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stefanosilva.bibliaonline.domain.Verse;
import com.stefanosilva.bibliaonline.repositories.VerseRepository;

@Service
public class VerseService {

	@Autowired
	VerseRepository repo;

	public Page<Verse> findAll(Pageable page) {

		Page<Verse> list = repo.findAll(page);
		return list;
	}

	public Verse findById(Integer id) {
		Optional<Verse> obj = repo.findById(id);

		if (obj != null) {
			return obj.get();
		}
		return null;
	}

	public List<Verse> search(Integer testamentId, Integer bookId,  Integer chapter) {

		List<Verse> list = new ArrayList<Verse>();
		
		if(testamentId > 0 && bookId > 0 && chapter > 0 ) {
			list = repo.searchByTestamentAndBookAndChapter(testamentId, bookId, chapter);
		}
		else if (testamentId > 0 && bookId>0)  {
			list = repo.searchByTestamentAndBook(testamentId, bookId);
		}
		else if (testamentId > 0) {
			list = repo.searchByTestament(testamentId);
		}
		
		return list;
	}
	
	public List<Integer> getDistinctChapter(Integer testament, Integer book) {
		return repo.getDistinctChapter( testament,  book);
	}

}
