package com.yougou.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品表
 * @author Administrator
 *
 */
public class Goods implements Serializable{
	private String goodsId;
	private String goodsName;
	private String goodsImg;	
	private String goodsColor;	
	private String goodsCImg;
	private String goodsSize;
	private String goodsDetails;
	private String goodsOC;
	private String goodsTC;
	private String goodsCC;
	private String goodsBrand;
	private String goodsSeason;
	private String goodsStyle;
	private String goodsSex;
	private String goodsInfo;
	private int goodsOldPrice;
	private int goodsNewPrice;
	private int goodsSales;
	private int goodsCollect;
	private String goodsTImg;
	private String goodsSizeSpec;
	private String goodsCLink;
	private int goodsPutAway;
	private Date goodsDate;
	
	public Goods() {
	}
	
	
	public String getGoodsCLink() {
		return goodsCLink;
	}
	public void setGoodsCLink(String goodsCLink) {
		this.goodsCLink = goodsCLink;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsSizeSpec() {
		return goodsSizeSpec;
	}
	public void setGoodsSizeSpec(String goodsSizeSpec) {
		this.goodsSizeSpec = goodsSizeSpec;
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
	public Date getGoodsDate() {
		return goodsDate;
	}

	public void setGoodsDate(Date goodsDate) {
		this.goodsDate = goodsDate;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsColor() {
		return goodsColor;
	}
	public int getGoodsPutAway() {
		return goodsPutAway;
	}
	public void setGoodsPutAway(int goodsPutAway) {
		this.goodsPutAway = goodsPutAway;
	}
	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}
	public String getGoodsCImg() {
		return goodsCImg;
	}
	public void setGoodsCImg(String goodsCImg) {
		this.goodsCImg = goodsCImg;
	}
	public String getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}
	public String getGoodsDetails() {
		return goodsDetails;
	}
	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
	}
	public String getGoodsOC() {
		return goodsOC;
	}
	public void setGoodsOC(String goodsOC) {
		this.goodsOC = goodsOC;
	}
	public String getGoodsTC() {
		return goodsTC;
	}
	public void setGoodsTC(String goodsTC) {
		this.goodsTC = goodsTC;
	}
	public String getGoodsCC() {
		return goodsCC;
	}
	public void setGoodsCC(String goodsCC) {
		this.goodsCC = goodsCC;
	}
	public String getGoodsBrand() {
		return goodsBrand;
	}
	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}
	public String getGoodsSeason() {
		return goodsSeason;
	}
	public void setGoodsSeason(String goodsSeason) {
		this.goodsSeason = goodsSeason;
	}
	public String getGoodsStyle() {
		return goodsStyle;
	}
	public void setGoodsStyle(String goodsStyle) {
		this.goodsStyle = goodsStyle;
	}
	public String getGoodsSex() {
		return goodsSex;
	}
	public void setGoodsSex(String goodsSex) {
		this.goodsSex = goodsSex;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
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
	public int getGoodsSales() {
		return goodsSales;
	}
	public void setGoodsSales(int goodsSales) {
		this.goodsSales = goodsSales;
	}
	public int getGoodsCollect() {
		return goodsCollect;
	}
	public void setGoodsCollect(int goodsCollect) {
		this.goodsCollect = goodsCollect;
	}
	public String getGoodsTImg() {
		return goodsTImg;
	}
	public void setGoodsTImg(String goodsTImg) {
		this.goodsTImg = goodsTImg;
	}


}
