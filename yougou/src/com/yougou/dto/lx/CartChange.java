package com.yougou.dto.lx;

public class CartChange {
	private String GoodsImg;
	private String GoodsName;
	private String GoodsColor;
	private int GoodsNewPrice;
	private String GoodsSize;
	private int StockNum;
	private int page;
	private int pageSize;
	
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
	public String getGoodsImg() {
		return GoodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		GoodsImg = goodsImg;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getGoodsColor() {
		return GoodsColor;
	}
	public void setGoodsColor(String goodsColor) {
		GoodsColor = goodsColor;
	}
	public int getGoodsNewPrice() {
		return GoodsNewPrice;
	}
	public void setGoodsNewPrice(int goodsNewPrice) {
		GoodsNewPrice = goodsNewPrice;
	}
	public String getGoodsSize() {
		return GoodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		GoodsSize = goodsSize;
	}
	public int getStockNum() {
		return StockNum;
	}
	public void setStockNum(int stockNum) {
		StockNum = stockNum;
	}

}
