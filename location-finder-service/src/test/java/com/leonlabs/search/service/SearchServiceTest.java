package com.leonlabs.search.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.leonlabs.search.entity.City;
import com.leonlabs.search.exception.ApplicationException;
import com.leonlabs.search.exception.NoResultFoundException;
import com.leonlabs.search.repository.jpa.CitySearchRepository;
import com.leonlabs.search.view.SearchQuery;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

	@InjectMocks
	private SearchServiceImpl searchService;
	
	@Mock
	private CitySearchRepository citySearchRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
//		searchService = new SearchServiceImpl();

	}

	@Test
	public void testGetModulePrice() throws NoResultFoundException, ApplicationException {
		
		when(citySearchRepository.findByNameContainingIgnoreCase(Mockito.anyString(), Mockito.anyObject()))
				.thenReturn(mockObject());

		assertEquals(new BigDecimal(.50), searchService.getCities(new SearchQuery("New", 0, 5)));
	}

	private List<City> mockObject() {
		List<City> list = new ArrayList<>();
		list.add(new City(1, "New Orleans", 1));
		list.add(new City(20, "New Delhi", 1));
		list.add(new City(115, "New York", 1));
		list.add(new City(247, "New Southwales", 1));
		list.add(new City(156, "Newark", 1));
		return list;
	}
}
