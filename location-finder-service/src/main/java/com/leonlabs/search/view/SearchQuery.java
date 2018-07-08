package com.leonlabs.search.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchQuery {
	
	private String freeText;
	
	private Integer startIndex;
	
	private Integer maxResult;
	
}
