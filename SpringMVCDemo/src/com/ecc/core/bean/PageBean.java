package com.ecc.core.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页信息
 * 
 * @author guoyl
 *
 */
public class PageBean {
	
	private int total;
	private List rows = new ArrayList();
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}


}
