package com.leonlabs.search.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.leonlabs.search.entity.City;

public interface CitySearchRepository extends JpaRepository<City, Integer>{

	//@Query("Select c from city c where c.name like %:freeText%")
	public List<City> findByNameContainingIgnoreCase(String freeText, Pageable pages);
	
}