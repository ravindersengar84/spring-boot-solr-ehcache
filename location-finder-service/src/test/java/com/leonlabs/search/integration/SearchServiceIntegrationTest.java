package com.leonlabs.search.integration;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leonlabs.search.Application;
import com.leonlabs.search.exception.ApplicationException;
import com.leonlabs.search.exception.NoResultFoundException;
import com.leonlabs.search.service.SearchServiceImpl;
import com.leonlabs.search.view.SearchQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class SearchServiceIntegrationTest {

	@Autowired
	private SearchServiceImpl searchService;
	

	@Test
	public void testGetModulePrice() throws NoResultFoundException, ApplicationException {
		assertEquals(new BigDecimal(.50), searchService.getCities(new SearchQuery("New", 0, 5)));
	}

}
