package com.leonlabs.search.view;

import java.util.List;

import lombok.Data;

@Data
public class SearchResult<T> {
	
	private List<T> searchResult;
	
	private Integer resultCount;
	
	private Long totalCount;
	
	
}
