package com.yougou.dto.zzq;

import java.util.List;

/**
 * 分类页面数据查询
 * @author Administrator
 *
 */
public class ProTypeData {
	private String goodsOC;
	private String goodsTC;
	private String goodsCC;
	private String goodsBrand;
	private String goodsBrandType;
	private String goodsStyle;
	private long goodsCount;
	private String goodsId;
	private String goodsTImg;
	private String goodsName;
	private int goodsOldPrice;
	private int goodsNewPrice;
	private String goodsData;
	private int page;
	private int pageSize;
	private String goodsType;
	private String goodsBrandInfo;
	private List<Object> breadcrumb; //面包屑
	
	private int minPrice;
	private int maxPrice;
	
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
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsTImg() {
		return goodsTImg;
	}
	public void setGoodsTImg(String goodsTImg) {
		this.goodsTImg = goodsTImg;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsStyle() {
		return goodsStyle;
	}
	public void setGoodsStyle(String goodsStyle) {
		this.goodsStyle = goodsStyle;
	}
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
	public long getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(long goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getGoodsData() {
		return goodsData;
	}
	public void setGoodsData(String goodsData) {
		this.goodsData = goodsData;
	}
	public String getGoodsBrandType() {
		return goodsBrandType;
	}
	public void setGoodsBrandType(String goodsBrandType) {
		this.goodsBrandType = goodsBrandType;
	}
	public String getGoodsBrandInfo() {
		return goodsBrandInfo;
	}
	public void setGoodsBrandInfo(String goodsBrandInfo) {
		this.goodsBrandInfo = goodsBrandInfo;
	}
	public List<Object> getBreadcrumb() {
		return breadcrumb;
	}
	public void setBreadcrumb(List<Object> breadcrumb) {
		this.breadcrumb = breadcrumb;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}		
}
