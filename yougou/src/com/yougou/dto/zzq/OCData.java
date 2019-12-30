package com.yougou.dto.zzq;

import java.util.List;

import com.yougou.pojo.TClassify;

public class OCData {
	private String ocName;
	private String ocId;
	private List<TCData> ocData;
	
	public String getOcName() {
		return ocName;
	}
	public void setOcName(String ocName) {
		this.ocName = ocName;
	}
	public String getOcId() {
		return ocId;
	}
	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	public List<TCData> getOcData() {
		return ocData;
	}
	public void setOcData(List<TCData> ocData) {
		this.ocData = ocData;
	}

	
	
}
