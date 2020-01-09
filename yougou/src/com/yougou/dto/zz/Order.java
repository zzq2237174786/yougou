package com.yougou.dto.zz;

import java.util.Date;

public class Order {
	private String orderId;
	private String stockId;
	private int orderNum;
	private String addressId;
	private Date orderDate;
	private int orderMsum;
	//存货id
	private String goodsId;
	private String goodsName;
	private String goodsColor;
	private String goodsSize;
	//地址	
	private String usersRegion;
	private String usersAddress;
	private String usersName;
	private String usersPhone;
	//账号
	private String usersNum;
	private String goodsTimg;
	private int usersMsum;
	private int usersPtime;
	
	
	
	
	public int getUsersMsum() {
		return usersMsum;
	}
	public void setUsersMsum(int usersMsum) {
		this.usersMsum = usersMsum;
	}
	
	public int getUsersPtime() {
		return usersPtime;
	}
	public void setUsersPtime(int usersPtime) {
		this.usersPtime = usersPtime;
	}
	public String getGoodsTimg() {
		return goodsTimg;
	}
	public void setGoodsTimg(String goodsTimg) {
		this.goodsTimg = goodsTimg;
	}
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
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
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
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
	public int getOrderMsum() {
		return orderMsum;
	}
	public void setOrderMsum(int orderMsum) {
		this.orderMsum = orderMsum;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
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
	public String getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
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
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
}
