package com.stefanosilva.bibliaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanosilva.bibliaonline.domain.Testament;

@Repository
public interface TestamentRepository extends JpaRepository<Testament, Integer> {

}
