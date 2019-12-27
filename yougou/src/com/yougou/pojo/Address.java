package com.yougou.pojo;

import java.io.Serializable;

public class Address implements Serializable{
	private String addressId;
	private String usersNum;
	private String uersName;
	private String uersRegion;
	private String usersAddress;
	private String usersPhone;
	private int usersPitch;
	
	public Address() {
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getUsersNum() {
		return usersNum;
	}

	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}

	public String getUersName() {
		return uersName;
	}

	public void setUersName(String uersName) {
		this.uersName = uersName;
	}

	public String getUersRegion() {
		return uersRegion;
	}

	public void setUersRegion(String uersRegion) {
		this.uersRegion = uersRegion;
	}

	public String getUsersAddress() {
		return usersAddress;
	}

	public void setUsersAddress(String usersAddress) {
		this.usersAddress = usersAddress;
	}

	public String getUsersPhone() {
		return usersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public int getUsersPitch() {
		return usersPitch;
	}

	public void setUsersPitch(int usersPitch) {
		this.usersPitch = usersPitch;
	}	
}
