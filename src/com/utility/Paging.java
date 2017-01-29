package com.utility;

public class Paging {
	private int totalPage = 0 ;
	private int pageNumber = 0 ; 
	public static int pageSize = 10 ;
	
	private int pageCount = 10 ; 
	private int beginPage = 0 ; 
	private int endPage = 0 ; 
	
	public Paging(int _pageNumber, int _pageSize, int totalCount) {
		this.pageNumber =  _pageNumber  ;
		Paging.pageSize =_pageSize;
		this.totalPage = (int)Math.ceil((double)totalCount / pageSize) ;
		
		this.beginPage = ( this.pageNumber -1 ) / this.pageCount * this.pageCount + 1 ;
		this.endPage = this.beginPage + this.pageCount - 1 ;  
		if( this.totalPage < this.endPage ){ this.endPage = this.totalPage ;  } 
		
    }
	public int getLastPageSet(){
		 return totalPage/pageCount * pageCount + 1;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		Paging.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
}
