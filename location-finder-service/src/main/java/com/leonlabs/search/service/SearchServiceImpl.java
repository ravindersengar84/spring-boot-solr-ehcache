package com.leonlabs.search.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonlabs.search.entity.City;
import com.leonlabs.search.entity.Country;
import com.leonlabs.search.exception.ApplicationException;
import com.leonlabs.search.exception.NoResultFoundException;
import com.leonlabs.search.repository.jpa.CitySearchRepository;
import com.leonlabs.search.repository.jpa.CountrySearchRepository;
import com.leonlabs.search.util.message.AppMessage;
import com.leonlabs.search.view.CityView;
import com.leonlabs.search.view.CountryView;
import com.leonlabs.search.view.SearchQuery;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private CitySearchRepository citySearchRepository;
	
	@Autowired
	private CountrySearchRepository countrySearchRepository;

	@Transactional(readOnly=true)
	public List<CityView> getCities(SearchQuery searchQuery) throws ApplicationException, NoResultFoundException {
		String freeTxt = searchQuery.getFreeText();
		Integer maxResult = searchQuery.getMaxResult();
		Integer startIndex = searchQuery.getStartIndex();
		List<CityView> listCity = new ArrayList<>();
		try {
			Sort sort = new Sort(new Sort.Order(Direction.ASC, "name"));
			Pageable pageable = new PageRequest(startIndex, maxResult, sort);
			List<City> cities = citySearchRepository.findByNameContainingIgnoreCase(freeTxt, pageable);
			
			listCity = cities.stream().map(city ->{
				CityView cityVO = new CityView();
				BeanUtils.copyProperties(city, cityVO);
				return cityVO;
			}).collect(Collectors.toList());
			return listCity;
		} catch (Exception e) {
			throw new ApplicationException(AppMessage.GeneralException.GENERAL_SERVER_EXCEPTION, e);
		}
	}
	
	@Transactional(readOnly=true)
	public List<CountryView> getCountries(SearchQuery searchQuery) throws ApplicationException, NoResultFoundException {
		String freeTxt = searchQuery.getFreeText();
		Integer maxResult = searchQuery.getMaxResult();
		Integer startIndex = searchQuery.getStartIndex();
		List<CountryView> listCountry = new ArrayList<>();
		try {
			Sort sort = new Sort(new Sort.Order(Direction.ASC, "name"));
			Pageable pageable = new PageRequest(startIndex, maxResult, sort);
			List<Country> countries = countrySearchRepository.findByNameContainingIgnoreCase(freeTxt, pageable);
			listCountry = countries.stream().map(country ->{
				CountryView countryVO = new CountryView();
				BeanUtils.copyProperties(country, countryVO);
				return countryVO;
			}).collect(Collectors.toList());
			return listCountry;
		} catch (Exception e) {
			throw new ApplicationException(AppMessage.GeneralException.GENERAL_SERVER_EXCEPTION, e);
		}
	}


}
