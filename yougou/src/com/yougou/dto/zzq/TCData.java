package com.yougou.dto.zzq;

import java.util.List;

import com.yougou.pojo.CClassify;

public class TCData {
	private String tcName;
	private List<CCData> tcData;
	private String tcId;
	public String getTcName() {
		return tcName;
	}
	public void setTcName(String tcName) {
		this.tcName = tcName;
	}
	public String getTcId() {
		return tcId;
	}
	public void setTcId(String tcId) {
		this.tcId = tcId;
	}
	public List<CCData> getTcData() {
		return tcData;
	}
	public void setTcData(List<CCData> tcData) {
		this.tcData = tcData;
	}
	
	
	
}
