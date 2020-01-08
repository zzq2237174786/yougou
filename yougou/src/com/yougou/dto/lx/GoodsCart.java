package com.yougou.dto.lx;

public class GoodsCart {
	private String cartId;
	private String stockId;//存货
	private int cartNum;//购物车件数
	private int cartPitch;//是否选中
	private String usersNum;//用户账号
	
	//存货表stock
	private String goodsId;
	private String goodsSize;
	private int stockNum;//商品数量
	
	//商品表goods
	private String goodsImg;
	private String goodsName;
	private String goodsColor;
	private int goodsNewPrice;
	
	//分页
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
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public int getCartPitch() {
		return cartPitch;
	}
	public void setCartPitch(int cartPitch) {
		this.cartPitch = cartPitch;
	}
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsColor() {
		return goodsColor;
	}
	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}
	public int getGoodsNewPrice() {
		return goodsNewPrice;
	}
	public void setGoodsNewPrice(int goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
	}
	
	
	
	
	

}
