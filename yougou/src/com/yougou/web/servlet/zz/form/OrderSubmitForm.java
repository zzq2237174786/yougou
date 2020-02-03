package com.yougou.web.servlet.zz.form;

import com.yougou.web.core.ActionForm;

public class OrderSubmitForm extends ActionForm{
	private String cartId;
	private String usersName;
	private String usersRegion;
	private String usersAddress;
	private String usersPhone;
	private String orderNum; //订单条数
	private String orderMSum; //订单总金额
	private String stockId;
	

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersRegion() {
		return usersRegion;
	}

	public void setUsersRegion(String usersRegion) {
		this.usersRegion = usersRegion;
	}

	public String getUsersAddress() {
		return usersAddress;
	}

	public void setUsersAddress(String usersAddress) {
		this.usersAddress = usersAddress;
	}

	public String getUsersPhone() {
		return usersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderMSum() {
		return orderMSum;
	}

	public void setOrderMSum(String orderMSum) {
		this.orderMSum = orderMSum;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}	
	
}
