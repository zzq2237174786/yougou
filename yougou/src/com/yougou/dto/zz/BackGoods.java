package com.yougou.dto.zz;

public class BackGoods {
	
	private String goodsId;
	private String goodsName;
	private int goodsOldPrice;
	private int goodsNewPrice;
	private int goodsPutaway;
	private int pageNo;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsOldPrice() {
		return goodsOldPrice;
	}
	public void setGoodsOldPrice(int goodsOldPrice) {
		this.goodsOldPrice = goodsOldPrice;
	}
	public int getGoodsNewPrice() {
		return goodsNewPrice;
	}
	public void setGoodsNewPrice(int goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
	}
	public int getGoodsPutaway() {
		return goodsPutaway;
	}
	public void setGoodsPutaway(int goodsPutaway) {
		this.goodsPutaway = goodsPutaway;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	
}
