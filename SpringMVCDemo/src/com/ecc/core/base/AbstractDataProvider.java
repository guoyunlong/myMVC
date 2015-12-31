package com.ecc.core.base;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 数据集合提供抽象类
 * 
 * 设置基本信息
 * 
 * @author guoyl
 * 
 */
public abstract class AbstractDataProvider implements IDataProvider {

	/**
	 * 基础SQL
	 */
	private String sqlBase;
	/**
	 * 在table中显示的所有列
	 */
	private List fields ;
	
	/**
	 * 页面查询表单标签和数据库列名对应关系，默认是一一对应的
	 */
	private List formFields;
	/**
	 * 数据库对象
	 */
	private JdbcTemplate jdbcTemplate;

	public String getSqlBase() {
		return sqlBase;
	}

	public void setSqlBase(String sqlBase) {
		this.sqlBase = sqlBase;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List getFields() {
		return fields;
	}

	public void setFields(List fields) {
		this.fields = fields;
	}

	public List getFormFields() {
		return formFields;
	}

	public void setFormFields(List formFields) {
		this.formFields = formFields;
	}

}
