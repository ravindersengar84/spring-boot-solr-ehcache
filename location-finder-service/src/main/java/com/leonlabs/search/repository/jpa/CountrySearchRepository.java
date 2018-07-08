package com.leonlabs.search.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.leonlabs.search.entity.Country;

public interface CountrySearchRepository extends JpaRepository<Country, Integer>{

	//@Query("Select c from country c where c.name like %:freeText%")
	public List<Country> findByNameContainingIgnoreCase(String freeText, Pageable pages);
}
