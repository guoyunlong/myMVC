package com.ecc.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 假分页器
 * 
 * 适用于数据总量较小的情况
 * 
 * @author guoyl
 * @version 1.0
 * @date 2014.09.16
 */
public class PageUtil {
	
	/**
	 * 当前页码
	 */
	private int currentPage;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 总行数
	 */
	private int totalRows;
	/**
	 * 每页显示条数
	 */
	private int avgRows = 5;
	/**
	 * 原集合
	 */
	private List list;

	public PageUtil() {
		super();
	}
	
	public PageUtil(int currentPage, int avgRows, List list) {
		super();
		this.currentPage = currentPage;
		this.avgRows = avgRows;
		this.list = list;
		this.totalRows = list.size();
		this.totalPage = (this.totalRows - 1) / this.avgRows + 1;
	}

	public List getPagerList() {
		List newList = new ArrayList();
		for(int i = (currentPage - 1) * avgRows; i < totalRows && i < currentPage * avgRows; i++) {
			newList.add(list.get(i));
		}
		return newList;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getAvgRows() {
		return avgRows;
	}
	public void setAvgRows(int avgRows) {
		this.avgRows = avgRows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}