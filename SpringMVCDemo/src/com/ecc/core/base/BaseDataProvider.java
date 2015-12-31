package com.ecc.core.base;

import java.util.List;

import com.ecc.core.bean.PageBean;
import com.ecc.core.util.ListUtil;
import com.ecc.core.util.SQLUtil;

/**
 * 数据集合提供抽象类
 * 
 * 
 * @author guoyl
 * 
 */
public class BaseDataProvider extends AbstractDataProvider {

	@Override
	public PageBean getPageInfo(int start, int limit, List listCondition) {
		PageBean pageBean = new PageBean();
		
		String sql = SQLUtil.createSelectSql(listCondition, this.getSqlBase());
		
		pageBean.setRows(ListUtil.format(this.getJdbcTemplate().queryForList(
				SQLUtil.toPage(start, limit, sql))));
		pageBean.setTotal(this.getJdbcTemplate().queryForInt(
				SQLUtil.toCount(sql)));
		return pageBean;
	}

	@Override
	public String exportExcel(String path, List conditionList) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
