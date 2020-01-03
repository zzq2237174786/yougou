package com.yougou.web.servlet.zz.form;

import com.yougou.web.core.ActionForm;

public class BackGoodsForm extends ActionForm {
	private String goodsId;
	private String gooosName;
	private String goodsOldPrice;
	private String goodsNewPrice;
	private String goodsPutaway;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGooosName() {
		return gooosName;
	}

	public void setGooosName(String gooosName) {
		this.gooosName = gooosName;
	}

	public String getGoodsOldPrice() {
		return goodsOldPrice;
	}

	public void setGoodsOldPrice(String goodsOldPrice) {
		this.goodsOldPrice = goodsOldPrice;
	}

	public String getGoodsNewPrice() {
		return goodsNewPrice;
	}

	public void setGoodsNewPrice(String goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
	}

	public String getGoodsPutaway() {
		return goodsPutaway;
	}

	public void setGoodsPutaway(String goodsPutaway) {
		this.goodsPutaway = goodsPutaway;
	}

}
