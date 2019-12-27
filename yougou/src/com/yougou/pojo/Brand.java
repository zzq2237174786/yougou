package com.yougou.pojo;

import java.io.Serializable;

public class Brand implements Serializable{
	private String brandId;
	private String brandName;
	private String brandLImg;
	private String brandSImg;
	private String brandInfo;
	private String brandParent;
	
	public Brand() {
	}
	
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandInfo() {
		return brandInfo;
	}
	public String getBrandLImg() {
		return brandLImg;
	}
	public void setBrandLImg(String brandLImg) {
		this.brandLImg = brandLImg;
	}
	public String getBrandSImg() {
		return brandSImg;
	}
	public void setBrandSImg(String brandSImg) {
		this.brandSImg = brandSImg;
	}
	public void setBrandInfo(String brandInfo) {
		this.brandInfo = brandInfo;
	}
	public String getBrandParent() {
		return brandParent;
	}
	public void setBrandParent(String brandParent) {
		this.brandParent = brandParent;
	}
}
