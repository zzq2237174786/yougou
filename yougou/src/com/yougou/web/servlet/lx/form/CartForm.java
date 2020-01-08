package com.yougou.web.servlet.lx.form;

import java.util.UUID;

import com.yougou.web.core.ActionForm;

public class CartForm extends ActionForm {
	private String goodsId;
	private String cartId;
	private String cartNum;
	private String cartPitch;
	private String usersNum;
	private String stockId;
	private String page;
	private String pageSize;
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getCartNum() {
		return cartNum;
	}

	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}

	public String getCartPitch() {
		return cartPitch;
	}

	public void setCartPitch(String cartPitch) {
		this.cartPitch = cartPitch;
	}

	public String getUsersNum() {
		return usersNum;
	}

	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
	
	

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	//生成随机cartId
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String str=uuid.toString();
		String uuidStr=str.replace("-", "");
		return uuidStr;
	}
}
