package com.stefanosilva.bibliaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanosilva.bibliaonline.domain.Verse;

public interface VerseRepository extends JpaRepository<Verse, Integer> {

}
