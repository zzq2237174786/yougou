package com.yougou.pojo;

import java.io.Serializable;

public class OClassify implements Serializable{
	private String ocId;
	private String ocName;
	private String oc_ename;
	
	public OClassify() {
	}

	public String getOcId() {
		return ocId;
	}

	public void setOcId(String ocId) {
		this.ocId = ocId;
	}

	public String getOcName() {
		return ocName;
	}

	public void setOcName(String ocName) {
		this.ocName = ocName;
	}

	public String getOc_ename() {
		return oc_ename;
	}

	public void setOc_ename(String oc_ename) {
		this.oc_ename = oc_ename;
	}	
}
