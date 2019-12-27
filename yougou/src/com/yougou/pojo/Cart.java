package com.yougou.pojo;

public class Cart {
	private String cartId;
	private String stockId;
	private int cartNum;
	private int cartPitch;
	private String userNum;
	
	public Cart() {
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

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}	
}
