package com.stefanosilva.bibliaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanosilva.bibliaonline.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
