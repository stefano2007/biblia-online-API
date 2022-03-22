package com.stefanosilva.bibliaonline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stefanosilva.bibliaonline.domain.Verse;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Verse obj WHERE obj.testament.id = :testament")
	List<Verse> searchByTestament(Integer testament);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Verse obj WHERE obj.testament.id = :testament and obj.book.id = :book")
	List<Verse> searchByTestamentAndBook(Integer testament, Integer book);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Verse obj WHERE obj.testament.id = :testament and obj.book.id = :book and chapter = :chapter")
	List<Verse> searchByTestamentAndBookAndChapter(Integer testament, Integer book, String chapter);
	
}
