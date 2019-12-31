package com.yougou.web.servlet.zzq.form;

import com.yougou.web.core.ActionForm;

public class IndexForm extends ActionForm{
	private String cartId;
	private String page;
	private String pageSize;

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

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
}
