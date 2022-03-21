package com.stefanosilva.bibliaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanosilva.bibliaonline.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
