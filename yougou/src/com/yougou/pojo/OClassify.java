package com.yougou.pojo;

import java.io.Serializable;

public class OClassify implements Serializable{
	private String ocId;
	private String ocName;
	private String ocEName;
	
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

	public String getOcEName() {
		return ocEName;
	}

	public void setOcEName(String ocEName) {
		this.ocEName = ocEName;
	}
}
