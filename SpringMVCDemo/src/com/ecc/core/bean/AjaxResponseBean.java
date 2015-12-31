package com.ecc.core.bean;

import org.apache.commons.collections.map.ListOrderedMap;


/**
 * 前台界面返回格式类
 * 
 * @author guoyl
 *
 */
public class AjaxResponseBean {
	private boolean success;// 是否成功
	private ListOrderedMap responseData;// 返回给前台的数据

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ListOrderedMap getResponseData() {
		return responseData;
	}

	public void setResponseData(ListOrderedMap responseData) {
		this.responseData = responseData;
	}

	public AjaxResponseBean(boolean success, ListOrderedMap responseData) {
		super();
		this.success = success;
		this.responseData = responseData;
	}

	public AjaxResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
