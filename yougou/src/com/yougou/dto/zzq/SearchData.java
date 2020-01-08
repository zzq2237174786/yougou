package com.yougou.dto.zzq;

import java.util.List;

public class SearchData {
	private long goodsCount;
	private List<NewProductData> goodsList;
	private String term;//条件
	private int page;
	private int pageSize;

	
	public long getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(long goodsCount) {
		this.goodsCount = goodsCount;
	}
	public List<NewProductData> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<NewProductData> goodsList) {
		this.goodsList = goodsList;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
