package com.ecc.core.base;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 统一处理数据库的新增 修改 删除
 * 
 * 设置基本信息
 * 
 * @author guoyl
 *
 */
public abstract class AbstractAction implements IAction {
	private String tableName;// 表名
	private String pkValue;// 主键 按 , 分割
//	private DataSource dataSource;//数据源
//	private String version = "VERSION";//乐观锁字段,默认为"version"字段,该字段类型为整型,每次修改判断该字段值

	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPkValue() {
		return pkValue;
	}

	public void setPkValue(String pkValue) {
		this.pkValue = pkValue;
	}

}
