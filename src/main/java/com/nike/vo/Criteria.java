package com.nike.vo;

public class Criteria {
	int page;
	int perPageNum=40;
	String keyword;
	String type;
	String order="created";
	

	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) { 
		this.order = order;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStartPage() {
		return (this.page-1)*perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			System.out.println("hahaha");
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

}
