package com.stefanosilva.bibliaonline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanosilva.bibliaonline.domain.Book;
import com.stefanosilva.bibliaonline.domain.Testament;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByTestament(Testament testament);
}
