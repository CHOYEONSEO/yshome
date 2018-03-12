package com.portfolio.yshome.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class CriteriaDTO {

	private int page;
	private int perPageNum;
	private int total;
	private String keyWord;
	private String searchType;
	
	public CriteriaDTO() {
	}

	public CriteriaDTO(int page, int perPageNum, String keyWord, String searchType) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.total = total;
		this.keyWord = keyWord;
		this.searchType = searchType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getTotal() {
		if((int)Math.ceil(page/(double)10) >= (int)Math.ceil(total/(double)10)) {
			return total;
		}
		total = 10 * (int)Math.ceil(page/(double)10);
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int nextPage() {
		int next = (int)Math.ceil(page/(double)10) * 10 + 1;
		return next;
	}
	
	public int prevPage() {
		int prev = ((int)Math.ceil(page/(double)10) - 2) * 10 + 9;
		return prev;
	}
	
	public int getPageStart() {
		
		return ((this.page - 1) * perPageNum) + 1;
	}
	
	public int getPageEnd() {
		return this.page * perPageNum;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		if (searchType == "") {
			searchType = null;
		} 
		this.searchType = searchType;
	}
	
	public String pageMake(int page, int paperNum, String keyWord, String searchType) {
		UriComponents uriCom = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("paperNum", paperNum)
				.queryParam("keyWord", keyWord)
				.queryParam("searchType", searchType)
				.build();

		return uriCom.toUriString();
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page 
				+ ", perPageNum = " + perPageNum 
				+ ", total = " + total 
				+ ", keyWord = " + keyWord 
				+ ", searchType = " + searchType +
				"]";
	}
}
