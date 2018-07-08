package com.leonlabs.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leonlabs.search.exception.ApplicationException;
import com.leonlabs.search.exception.NoResultFoundException;
import com.leonlabs.search.view.CityView;
import com.leonlabs.search.view.SearchQuery;

@Service
public interface SearchService {
	
	public List<CityView> getCities(SearchQuery searchQuery) throws ApplicationException, NoResultFoundException;

}
