package com.ecc.core.bean;

import org.apache.commons.collections.map.ListOrderedMap;

/**
 * 导出信息返回类
 * 
 * @author guoyl
 * 
 */
public class ExportResponseBean {
	public static final int EXCEL = 1;
	public static final int PDF = 2;
	public static final int WORD = 3;
	private boolean success;// 是否成功
	private ListOrderedMap responseData;// 返回给前台的数据
	private int fileType = EXCEL;

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

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public ExportResponseBean(boolean success, ListOrderedMap responseData) {
		super();
		this.success = success;
		this.responseData = responseData;
	}

	public ExportResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
