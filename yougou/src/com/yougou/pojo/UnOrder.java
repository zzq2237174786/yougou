package com.yougou.pojo;

import java.io.Serializable;
import java.util.Date;


public class UnOrder implements Serializable{
	private String orderId;
	private String stockId;
	private String orderNum;
	private String addressId;
	private Date orderDate;
	private int orderMSum;
	private String usersNum;
		
	public UnOrder() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderMSum() {
		return orderMSum;
	}

	public void setOrderMSum(int orderMSum) {
		this.orderMSum = orderMSum;
	}

	public String getUsersNum() {
		return usersNum;
	}

	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
}
