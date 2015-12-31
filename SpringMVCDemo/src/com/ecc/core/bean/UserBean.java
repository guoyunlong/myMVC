package com.ecc.core.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	/**
	 * 登陆帐户
	 */
	private String userId;
	
	/**
	 * 登陆展示名
	 */
	private String userName;
	/**
	 * 最后登陆日期
	 */
	private String lastDate;
	/**
	 * 登陆次数
	 */
	private String number;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
