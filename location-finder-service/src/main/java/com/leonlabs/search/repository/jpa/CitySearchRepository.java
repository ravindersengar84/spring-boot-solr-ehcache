package com.leonlabs.search.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonlabs.search.entity.City;

@Repository
public interface CitySearchRepository extends JpaRepository<City, Integer>{

	//@Query("Select c from city c where c.name like %:freeText%")
	//@Cacheable(value = "city.byName", key = "#name", unless = "#name != null")
	
	public List<City> findByNameContainingIgnoreCase(String freeText, Pageable pages);
	
}