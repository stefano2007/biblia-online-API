package com.stefanosilva.bibliaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanosilva.bibliaonline.domain.Testament;

public interface TestamentRepository extends JpaRepository<Testament, Integer> {

}
