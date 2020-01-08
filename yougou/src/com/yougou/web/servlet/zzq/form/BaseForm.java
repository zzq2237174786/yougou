package com.yougou.web.servlet.zzq.form;

import com.yougou.web.core.ActionForm;

public class BaseForm extends ActionForm{
		private String page;
		private String pageSize;
		private String term;
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
		public String getTerm() {
			return term;
		}
		public void setTerm(String term) {
			this.term = term;
		}
}
