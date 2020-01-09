package com.yougou.web.servlet.zz.form;

import com.yougou.web.core.ActionForm;

public class OrderForm extends ActionForm {
	private String orderId;
	private String stockId;
	private String orderNum;
	private String addressId;
	private String orderDate;
	private String orderMsum;
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
	private String usersNum;
	private String goodsTimg;
	private String usersMsum;
	private String usersPtime;
	
	public String getUsersMsum() {
		return usersMsum;
	}
	public void setUsersMsum(String usersMsum) {
		this.usersMsum = usersMsum;
	}
	
	public String getUsersPtime() {
		return usersPtime;
	}
	public void setUsersPtime(String usersPtime) {
		this.usersPtime = usersPtime;
	}
	public String getGoodsTimg() {
		return goodsTimg;
	}
	public void setGoodsTimg(String goodsTimg) {
		this.goodsTimg = goodsTimg;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	private String pageNo;
	
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderMsum() {
		return orderMsum;
	}
	public void setOrderMsum(String orderMsum) {
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
