package com.yougou.dto.zzq;

public class NewProductData {
	private int page;
	private int pageSize;
	private String goodsTImg;
	private String goodsName;
	private String goodsId;
	private int goodsNewPrice;
	private String brandSImg;
	private String brandId;
	private String goodsOC;
	private String goodsStyle;
	
	
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getGoodsStyle() {
		return goodsStyle;
	}
	public void setGoodsStyle(String goodsStyle) {
		this.goodsStyle = goodsStyle;
	}
	public String getBrandSImg() {
		return brandSImg;
	}
	public void setBrandSImg(String brandSImg) {
		this.brandSImg = brandSImg;
	}
	public String getGoodsOC() {
		return goodsOC;
	}
	public void setGoodsOC(String goodsOC) {
		this.goodsOC = goodsOC;
	}
	public String getGoodsTImg() {
		return goodsTImg;
	}
	public void setGoodsTImg(String goodsTImg) {
		this.goodsTImg = goodsTImg;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsNewPrice() {
		return goodsNewPrice;
	}
	public void setGoodsNewPrice(int goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
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
