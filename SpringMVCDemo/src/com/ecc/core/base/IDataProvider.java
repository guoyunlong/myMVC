package com.ecc.core.base;

import java.util.List;

import com.ecc.core.bean.PageBean;

/**
 * 数据集提供封装接口
 * 
 * @author guoyl
 * 
 */
public interface IDataProvider {

	/**
	 * 页面列表
	 * @param start 开始行
	 * @param limit 每页行数
	 * @param nature
	 * @return
	 */
	PageBean getPageInfo(int start, int limit, List conditionList);

	/**
	 * EXCEL导出
	 * 
	 * @param path
	 * @param nature
	 * @return
	 */
	String exportExcel(String path, List conditionList);
	
	
	
}